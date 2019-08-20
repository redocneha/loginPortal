pipeline {

    agent any
    
    stages {
         stage ('Compile Stage') {
            steps {
                 bat 'mvn -f Register_Backend/pom.xml clean install'
                 bat 'cd Register_Frontend && npm install && npm run build'
                 bat 'mvn -f UserConfirmation_Backend/pom.xml clean install'
                 bat 'cd UserConfirmation_Frontend && npm install && npm run build'
                 bat 'mvn -f Forgotpassword_Backend/pom.xml clean install'
                 bat 'cd Forgotpassword_Frontend && npm install && npm run build'
                 bat 'mvn -f DataRetrievalService_BackEnd/pom.xml clean install'
                 bat 'mvn -f LoginService_BackEnd/pom.xml clean install'
                 bat 'cd LoginService_Frontend && npm install && npm run build'
                 bat 'mvn -f ChangePasswordService_Backend/pom.xml clean install'
                 bat 'cd ChangePasswordService_Frontend && npm install && npm run build'
            }
         }
    }
}
