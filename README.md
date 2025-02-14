
# Jenkins Customizado com Scripts de Inicialização Groovy

Este repositório fornece uma versão Dockerizada do Jenkins com scripts de inicialização em **Groovy** para configuração automatizada. O **Dockerfile** garante que o Jenkins seja iniciado com configurações personalizadas definidas pelos scripts Groovy, facilitando a automação e garantindo uma configuração consistente.

## Funcionalidades
- Jenkins configurado via Docker.
- Configuração automática usando scripts Groovy.
- Implantação e setup rápidos.
- Possibilidade de instalação automática de plugins e configuração de jobs.

## Pré-requisitos
- **Docker** e **Docker Compose** instalados na sua máquina.
- Conhecimento básico de Jenkins e scripts Groovy.

## Estrutura do Projeto
```
├── Dockerfile                # Dockerfile para construir a imagem do Jenkins
├── init.groovy.d/           # Pasta contendo todos os scripts de inicialização Groovy
│   ├── auth.groovy
│   ├── job.groovy
├── jenkins_home/             # Dados persistentes do Jenkins (opcional)
└── README.md                 # Documentação do projeto
```

## Como Começar

### Passo 1: Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/jenkins-groovy-docker.git
```

### Passo 2: Construir a Imagem Docker
```bash
docker build -t meu-jenkins .
```

### Passo 3: Executar o Container do Jenkins
```bash
docker run -d -p 8080:8080 --name meu-jenkins meu-jenkins
```

- **Porta 8080**: Interface Web do Jenkins  
- **Porta 50000**: Comunicação com agentes Jenkins

### Passo 4: Acessar o Jenkins
Abra o navegador e acesse `http://localhost:8080`. O Jenkins solicitará a senha de desbloqueio, que pode ser encontrada no arquivo `jenkins_home/secrets/initialAdminPassword`.

### Passo 5: Verificar a Execução dos Scripts Groovy
Confira os logs do Jenkins para verificar se os scripts Groovy foram executados corretamente:
```bash
docker logs jenkins-groovy
```

## Personalização do Jenkins com Groovy
Coloque seus scripts Groovy no diretório `groovy-scripts/`. Eles serão executados automaticamente quando o container for iniciado pela primeira vez.

### Exemplo de Script Groovy (`groovy-scripts/01-configure-admin.groovy`)
```groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin")
instance.setSecurityRealm(hudsonRealm)
instance.save()
```

## Persistência
O diretório `jenkins_home` é montado como volume para garantir que os dados do Jenkins (jobs, plugins e configurações) sejam preservados entre os reinícios do container.

## Resolução de Problemas
- Verifique os logs do container em caso de erros:
  ```bash
  docker logs jenkins-groovy
  ```
- Certifique-se de que o diretório `jenkins_home` tenha as permissões corretas.
