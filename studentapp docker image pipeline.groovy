pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = 'tejal57'
        DOCKERHUB_PASSWORD = 'teja123456'
        IMAGE_NAME_FRONTEND = 'frontedimage'
        IMAGE_NAME_BACKEND = 'backendimage'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/tejal57/studentapp-3tier-docker-image.git'
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker-compose -f docker-compose.yml build'
            }
        }

        stage('Run Docker Containers') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

        stage('Login to Docker Hub') {
            steps {
                sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'

            }
        }

        stage('Push Docker Images to Hub') {
            steps {
                sh 'docker tag ${IMAGE_NAME_FRONTEND}:latest ${DOCKERHUB_USERNAME}/${IMAGE_NAME_FRONTEND}:latest'  // Push frontend image
                sh 'docker push ${DOCKERHUB_USERNAME}/${IMAGE_NAME_FRONTEND}:latest'
         
                sh 'docker tag ${IMAGE_NAME_BACKEND}:latest ${DOCKERHUB_USERNAME}/${IMAGE_NAME_BACKEND}:latest'  // Push backend image
                sh 'docker push ${DOCKERHUB_USERNAME}/${IMAGE_NAME_BACKEND}:latest'
            }
        }
    }
}
