COMPILING A SPECIFIC BRANCH 
======================================================

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
        stage('compile other branch') 
        {
            steps 
            {
                git branch: 'declarative' ,
                url: 'https://github.com/Ds-jedi/game-of-life'
                sh 'mvn compile'
            }
       }
    }
}