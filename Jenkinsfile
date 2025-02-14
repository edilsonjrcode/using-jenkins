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
                sh 'docker build -t my-jenkins .'
            }
        }

        stage('Test') {
            steps {
                sh 'docker run --rm my-jenkins test'
            }
        }
    }
}