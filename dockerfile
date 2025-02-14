FROM jenkins/jenkins:lts

# If you want to install any additional plugins, you can do so here
# RUN /usr/local/bin/install-plugins.sh <plugin1> <plugin2> ...
RUN jenkins-plugin-cli --plugins git workflow-aggregator pipeline-stage-view docker-workflow blueocean credentials-binding

# Copy the groovy script to the init.groovy.d directory
COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/

USER jenkins