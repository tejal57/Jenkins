pipeline {
    agent {label "agent10" }
    stages{
        stage("install apache") {
            steps{
                sh '''
                sudo apt update 
                sudo apt install apache2 -y
                sudo systemctl start apache2
                sudo apt install unzip -y
                '''
            }
        }
        stage("download template and unzip") {
            steps{
                sh '''
                sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page296/little-fashion.zip
                sudo unzip little-fashion.zip
                '''
            }
        }
        stage("move template in /var/www/html/") {
            steps{
                sh '''
                sudo mv /home/ubuntu/workspace/project2/2127_little_fashion/* /var/www/html/
                '''
            }
        }
    }
}