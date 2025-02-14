import jenkins.model.*
import hudson.model.*

// Acessando a instância do Jenkins
def jenkins = Jenkins.instance

// Definindo o nome do job
def jobName = 'my-pipeline'

// Verificando se o job já existe
def job = jenkins.getItem(jobName)

if (!job) {
    // Criando um novo job Pipeline
    def pipelineJob = jenkins.createProject(WorkflowJob, jobName)

    // Definindo o script do pipeline
    def pipelineScript = """
    pipeline {
        agent any
        stages {
            stage('Hello') {
                steps {
                    echo 'Hello world...'
                }
            }
        }
    }
    """

    // Configurando o script de pipeline no job
    pipelineJob.definition = new CpsFlowDefinition(pipelineScript, true)
    
    // Salvando o job
    pipelineJob.save()
    
    println "Pipeline job '${jobName}' criado com sucesso."
} else {
    println "O job '${jobName}' já existe."
}
