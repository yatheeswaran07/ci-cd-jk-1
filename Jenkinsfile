pipeline {
 agent any
 tools {
 maven 'Maven'
 }
 stages {
 stage('Build') {
 steps {
 script {
 bat "mvn clean package"
 }
 }
 post {
 success {
 echo "Archiving the Artifacts"
 archiveArtifacts artifacts: '**/target/*.war'
 }
 }
 }
 stage('Deploy to Tomcat') {
 steps {
 script {
deploy adapters: [tomcat9(credentialsId: '2feb930a-4c45-4f78-bd7c-e29f7f5c4f89', path: '', url: 'http://20.244.45.6:9090')], contextPath: 'calculation', war: '**/*.war' }
 }
 }
 }
}
