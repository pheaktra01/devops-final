pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *') // every 5 minutes
    }

    environment {
        APP_DIR = "."
        PLAYBOOK = "ansible/deploy.yml"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/pheaktra01/devops-final.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh """
                ansible-playbook -i ansible/inventory.ini ${PLAYBOOK}
                """
            }
        }
    }

    post {

        success {
            echo 'Build successful'
        }

        failure {
            emailext (
                to: "srengty@gmail.com",
                cc: "${env.GIT_COMMITTER_EMAIL}",
                subject: "❌ Jenkins Build Failed - ${env.JOB_NAME}",
                body: """
    Build failed in Jenkins.

    Job: ${env.JOB_NAME}
    Build Number: ${env.BUILD_NUMBER}

    Check console output for details.
    """
            )
        }
    }
}