pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/PremchandP07/devops-java-app.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t devops-java-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8081:8081 devops-java-app || true'
            }
        }
    }
}