U need parameterized trigger plugin to be installed for this to work

pipeline {
    agent any
    parameters {
        string(name: 'ENV', description: 'Trump')
    }
    stages {
        stage('JOB_1 with parameters') {
            steps {
                script{
                    echo "${params.ENV}"
                }
            }
        }
        stage("JOB_2") {
            steps {
                build job: 'job_2', parameters: [string(name: 'ENV', value: "${params.ENV}")]  ///u can set ur own parmaters here 
            }                                                                                  /// here it will take env=trump
        }
    }
    }

}