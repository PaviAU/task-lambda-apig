pipeline {
    agent any
    stages {
        stage('Display a message') {
            steps {
                echo "Job A -- Hello World"
            }
        }
        
    }
}
