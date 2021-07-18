/// scripted pipeline in groovy

node
{
   stage('scm')
   {
        git 'https://github.com/Ds-jedi/game-of-life'
   }

   stage('build')
   {
        sh 'mvn clean package'
   }
}

