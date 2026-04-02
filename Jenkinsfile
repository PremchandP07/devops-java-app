pipeline {
    agent any

    stages {

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t devops-java-app .
                '''
            }
        }

        stage('Stop & Remove Old Container') {
            steps {
                sh '''
                docker stop devops-container || true
                docker rm devops-container || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d -p 8081:8081 --name devops-container devops-java-app
                '''
            }
        }

    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Deployment Failed!'
        }
    }
}