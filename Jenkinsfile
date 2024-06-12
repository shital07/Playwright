pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage('Run testCase') {

            steps {
                echo 'Hello'
                sh "mvn clean install"
            }
        }

        stage('Publish the html reporl'){
            steps{
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: false,
                             keepAll: false,
                             reportDir: 'extent-reports',
                             reportFiles: 'index.html',
                             reportName: 'Automation Report',
                             reportTitles: '',
                             useWrapperFileDirectly: true])
            }
        }
    }




}