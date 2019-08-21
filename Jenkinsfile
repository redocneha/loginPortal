pipeline {

    agent any
    
    stages {
         stage ('Deploy Stage') {
            steps {
                bat 'start java -jar Register_Backend/target/Register_Backend.jar'
                bat 'cd Register_Frontend/build && start python -m http.server 8006'
              
                /*
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
                */
                
            }
         }
    }
}
