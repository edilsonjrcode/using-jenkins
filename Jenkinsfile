pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/edilsonjrcode/using-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'docker build -t meu-app .'
            }
        }

        stage('Test') {
            steps {
                sh 'docker run --rm meu-app test'
            }
        }
    }
}