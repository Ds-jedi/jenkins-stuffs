pipeline {
    agent { label 'REDHAT' }
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
    }
}