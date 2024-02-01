pipeline {
    agent { label 'kupepod' }
    tools {
        maven '3.9.6'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Insurance-Recommendation-Project/Auth_register']])
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                   sh 'docker build -t elmachkouriimane/authregister .'
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker', variable: 'Docker')]) {
                        sh "docker login -u elmachkouriimane -p ${Docker}"
                        sh "docker push elmachkouriimane/authregister"
                    }
                }
            }
        }

       stage('Deploy App') {
         steps {
          script {
          withKubeConfig(caCertificate: '', clusterName: '', contextName: '', credentialsId: 'kubeconfig', namespace: '', restrictKubeConfigAccess: false, serverUrl: '') {
                sh "kubectl apply -f deployment.yaml"
              }
        }
      }
    }
    }
}
