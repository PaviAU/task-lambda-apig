pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Job B"
            }
        }
        stage('triggerjobA') {
            steps {
               // build job: "jobA", wait: true not re
               // addd
               // testing 
               
            }
        }
    }
}
