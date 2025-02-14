FROM jenkins/jenkins:lts

RUN jenkins-plugin-cli --plugins git workflow-aggregator pipeline-stage-view docker-workflow blueocean credentials-binding

COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false