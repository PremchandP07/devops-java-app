pipeline {
    agent any

    stages {

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