pipeline {

    agent any
    
    stages {
         stage ('Compile Stage') {
            steps {
               //  bat 'mvn -f Register_Backend/pom.xml clean install'
               //  bat 'cd Register_Frontend && npm install && npm run build'
                
                 bat 'mvn -f UserConfirmation_Backend/pom.xml clean install'
                 bat 'cd UserConfirmation_Frontend && npm install && npm run build'
                
                 bat 'mvn -f Forgotpassword_Backend/pom.xml clean install'
                 bat 'cd forgotpassword_frontend && npm install && npm run build'
                
             //    bat 'mvn -f DataRetrievalService_BackEnd/pom.xml clean install'
                 bat 'mvn -f LoginService_BackEnd/pom.xml clean install'
              //   bat 'cd LoginService_Frontend && npm install && npm run build'
                
                 bat 'mvn -f ChangePasswordService_Backend/pom.xml clean install'
              //   bat 'cd ChangePasswordService_Frontend && npm install && npm run build'
                
            //     bat 'mvn -f Admin_Backend/pom.xml clean install'
             //    bat 'cd Admin_Frontend && npm install && npm run build'
                
              //   bat 'mvn -f Edit_Profile_Backend/pom.xml clean install'
              //   bat 'cd Edit_Profile_Frontend && npm install && npm run build'
            }
         }
    }
}
