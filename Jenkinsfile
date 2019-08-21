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
                bat 'cd forgotpassword_frontend && npm install && npm run build'
                
                bat 'mvn -f DataRetrievalService_BackEnd/pom.xml clean install'
                bat 'mvn -f LoginService_BackEnd/pom.xml clean install'
                bat 'cd LoginService_Frontend && npm install && npm run build'
                
                bat 'mvn -f ChangePasswordService_Backend/pom.xml clean install'
                bat 'cd ChangePasswordService_Frontend && npm install && npm run build'
                
                bat 'mvn -f Admin_Backend/pom.xml clean install'
                bat 'cd Admin_Frontend && npm install && npm run build'
                
                bat 'mvn -f Edit_Profile_Backend/pom.xml clean install'
                bat 'cd Edit_Profile_Frontend && npm install && npm run build'
            }
         }
        
         stage ('Deploy Stage') {
            steps {
                bat 'start java -jar Register_Backend/target/Register_Backend.jar'
                bat 'cd Register_Frontend && cd build && start python -m http.server 8006'
                
                bat 'start java -jar UserConfirmation_Backend/target/UserConfirmation_Backend.jar'
                bat 'cd UserConfirmation_Frontend && cd build && start python -m http.server 8002'
                
                bat 'start java -jar Forgotpassword_Backend/target/Forgotpassword_Backend.jar'
                bat 'cd forgotpassword_frontend && cd build && start python -m http.server 8010'
                
                bat 'start java -jar DataRetrievalService_BackEnd/target/DataRetrievalService_BackEnd.jar'
                bat 'start java -jar LoginService_BackEnd/target/LoginService_BackEnd.jar'
                bat 'cd LoginService_Frontend && cd build && start python -m http.server 8014'
                
                bat 'start java -jar ChangePasswordService_Backend/target/ChangePasswordService_Backend.jar'
                bat 'cd ChangePasswordService_Frontend && cd build && start python -m http.server 8016'
                
                bat 'start java -jar Edit_Profile_Backend/target/Edit_Profile_Backend.jar'
                bat 'cd Edit_Profile_Frontend && cd build && start python -m http.server 8019'
                
                bat 'start java -jar Admin_Backend/target/Admin_Backend.jar'
                bat 'cd Admin_Frontend && cd build && start python -m http.server 8021'
                
            }
         }
    }
}
