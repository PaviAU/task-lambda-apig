pipeline {
    agent any

    environment{
        def s3BucketName = "task-lambda-apigateway-bucket-29122023";
        def s3BucketRegion = "us-east-1";
        def tfStateFile = "./terraform.tfstate";
        def dynamoDBTable = "task-lambda-apigateway-table-29122023";
    }
    stages {
        stage('build') {
            steps {
                echo "Job B"
            }
        }
        stage('Checkout stage') {
            steps {
                    git branch: 'main', credentialsId: '7302c566-e079-4a9d-af26-b6eb72aff582', url: 'https://github.com/PaviAU/task-lambda-apig'
                
            }

            stage('Terraform init & Plan stage') {
            steps {
                    sh "terraform init -force-copy -reconfigure -backend-config  'bucket=${s3BucketName}' -backend-config  region=${s3BucketRegion} -backend-config  'key=${tfstateFile}' -backend-config dynamodb_table='${dynamoDBTable}'"
                    sh "terraform validate"
                    sh "terraform plan"
                  }
                
            }

            stage('Terraform apply stage') {
            steps {
                    sh "terraform apply --auto-approve "
                  }
                
            }
        }
    }

