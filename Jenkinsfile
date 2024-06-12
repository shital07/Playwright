pipeline{
    agent any
    tools {
        maven 'mvn'
    }
    stages{
        stage('clone'){

            steps{
                echo 'Hello'
                sh "mvn clean install"
            }
        }
    }
}