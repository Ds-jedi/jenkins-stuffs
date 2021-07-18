pipeline {
    agent any
    stages 
    {
        stage('Source')
        {
            steps 
            {
                git 'https://github.com/Ds-jedi/game-of-life'
            }
        }
        stage('Package')
        {
            steps 
            {
                sh 'mvn package'
            }
        }
        stage("BUILD downstream job")
        {
            script
            {
                steps
                {
                    build job: 'downstream JOB B'
                }

            }
        }
    }
}