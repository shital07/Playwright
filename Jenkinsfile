pipeline {
   agent { dockerfile true }
   environment{
      ENV_VAR= "test"
   }
    stages {

       stage('Dev Checkout'){
                        steps{
git credentialsId: 'GitID',
                        url: 'https://github.com/shital07/Playwright',
                        branch: 'main'
                echo 'Git checkout is successful'
          echo "${env.BUILD_ID}"
          
          echo "${env.ENV_VAR}"


                        }
       }

        stage('Checkout git') {
            steps {
                // checkout the source code from Git using credentials
                git credentialsId: 'GitID',
                        url: 'https://github.com/shital07/Playwright',
                        branch: 'main'
                echo 'Git checkout is successful'
            }
        }
        stage('Run testCase') {

            steps {
                echo 'Starting Execution'
                sh "mvn clean install"
            }
        }

        stage('Publish the html reporl') {
            steps {
                publishHTML([allowMissing          : false,
                             alwaysLinkToLastBuild : false,
                             keepAll               : false,
                             reportDir             : 'extent-reports',
                             reportFiles           : 'index.html',
                             reportName            : 'Automation Report',
                             reportTitles          : '',
                             useWrapperFileDirectly: false])

                archiveArtifacts '**/*.html'
            }
        }
    }
   post{
always{
   mail to: shital0711@gmail.com, subject: 'The Pipeline run :('
}
      success{
mail to : shital0711@gmail.com,subject:'The pipeline ran sucessfully'
      }
      
   }


}
