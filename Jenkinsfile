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
deploy adapters: [tomcat9(credentialsId: 'a1c7a8ed-1574-4955-89ad-0efd8db0b466', path: '', url: 'http://localhost:8080')], contextPath: '/ci-cd-jk-1', war: '**/*.war' }
 }
 }
 }
}
