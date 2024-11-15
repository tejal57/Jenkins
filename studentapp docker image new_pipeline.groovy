pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
             git branch: 'main', credentialsId: 'git', url: 'https://github.com/tejal57/studentapp-3tier-docker-image.git'
            }
        }                                                                                       

        stage('Run Docker Compose') {
            steps {
                script {
                    sh 'docker-compose up -d --build'
                }
            }
        }
    }
}






   
    
    
// /home/ubuntu/studentapp-3tier-docker-image/frontend
 // /home/ubuntu/studentapp-3tier-docker-image/backend

//   /var/lib/jenkins/workspace/studentapp2/frontend 
//   /var/lib/jenkins/workspace/studentapp2/backend    
