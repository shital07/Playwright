pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage('clone') {

            steps {
                echo 'Hello'
                sh "mvn clean install"
            }
        }
    }

    publishHTML([allowMissing: false,
                 alwaysLinkToLastBuild: false,
                 keepAll: false,
                 reportDir: 'extent-reports',
                 reportFiles: 'index.html',
                 reportName: 'Automation Report', 
                 reportTitles: '',
                 useWrapperFileDirectly: true])


}