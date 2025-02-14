import jenkins.model.*
import org.jenkinsci.plugins.workflow.job.WorkflowJob

def jenkins = Jenkins.getInstance()
def job = new WorkflowJob(jenkins, "my-pipeline")
job.setDefinition(new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition('''
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/edilsonjrcode/using-jenkins.git'
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Construindo aplicação..."'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Executando testes..."'
            }
        }
    }
}
''', true))
jenkins.add(job)
jenkins.save()
