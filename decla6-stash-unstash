pipeline {
    agent any
    stages 
    {
        stage('Build')
        {
            agent 'jenkins master'
            steps 
            {
                git url :'https://github.com/Ds-jedi/game-of-life'
                sh 'mvn package'
                stash name : 'goljarfile' , includes: 'target/gameoflife.jar'
            }
        }
        stage('deploy') 
        {
            agent 'pre-prod-env'
            steps 
            {
                unstash 'goljarfile'
                git url: 'https://github.com/Ds-jedi/game-of-life'
                sh 'ansible-playbook -i hosts deploy.yaml'
            }
       }
    }
}