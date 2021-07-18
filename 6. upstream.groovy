Build trigger decla pipeline upstream project
####################################################


pipeline {
    agent any
    triggers 
    {
        upstream(upstreamProjects: 'dummy', threshold:hudson.model.Result.SUCCESS)
    }
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