pipeline {
    agent any

    stages {

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t devops-java-app .'
            }
        }

        stage('Clean Old Containers') {
            steps {
                sh '''
                docker stop $(docker ps -q) || true
                docker rm $(docker ps -aq) || true
                '''
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8081:8081 --name devops-container devops-java-app'
            }
        }
    }
}