pipeline {
    agent any

    environment{
       /*  def s3BucketName = "task-lambda-apigateway-bucket-29122023";
        def s3BucketRegion = "us-east-1";
        def tfStateFile = "./terraform.tfstate";
        def dynamoDBTable = "task-lambda-apigateway-table-29122023"; */
        def gitInfraBranchName          = "main";
    }
    stages {
        stage('build') {
            steps {
                echo "Job B"
            }
        }
       /*  stage('Checkout stage') {
            steps {
                    git branch: 'main', credentialsId: '7302c566-e079-4a9d-af26-b6eb72aff582', url: 'https://github.com/PaviAU/task-lambda-apig'
                
            } */

             stage('Git Checkout infra'){
            steps{
                //Clone the git repository.
                //checkout scmGit(branches: [[name: "*/main"]], extensions: [], userRemoteConfigs: [[credentialsId: 'github-ssh-key', url: 'git@github.com:PaviAU/task-lambda-apig.git']])
                checkout scmGit(branches: [[name: "*/${gitInfraBranchName}"]], extensions: [], userRemoteConfigs: [[credentialsId: '7302c566-e079-4a9d-af26-b6eb72aff582', url: 'https://github.com/PaviAU/task-lambda-apig']])
                sh script: "git checkout ${gitInfraBranchName}"
                sh script: "git pull origin ${gitInfraBranchName}"
                sh script: "pwd && ls"
            }
        }



            stage('Terraform init & Plan stage') {
            steps {
                    // sh "terraform init -force-copy -reconfigure -backend-config  'bucket=${s3BucketName}' -backend-config  region=${s3BucketRegion} -backend-config  'key=${tfstateFile}' -backend-config dynamodb_table='${dynamoDBTable}'"
                    sh "terraform init"
                    // sh "terraform fmt -list=true -write=false -diff=true -check=true"
                    sh "terraform validate"
                   // sh "terraform plan"
                  }
                
            } 

            stage('Terraform plan stage') {
            steps {
                    sh "terraform plan "
                  }
                
            }  

           /*  stage('Terraform apply stage') {
            steps {
                    sh "terraform apply --auto-approve "
                  }
                
            } */
        }
    }

