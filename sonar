node 
{
    stage('scm')
    {
        git 'https://github.com/Ds-jedi/game-of-life'
    }
    stage('build')
    {
        sh 'mvn package'
    }
    stage('Sonar') 
    {
        withSonarQubeEnv('sonar') 
        {
            sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
        }
    }
}