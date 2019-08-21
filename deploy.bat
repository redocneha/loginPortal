 start java -jar Register_Backend/target/Register_Backend.jar
 cd Register_Frontend/build && start python -m http.server 8006
 start java -jar UserConfirmation_Backend/target/UserConfirmation_Backend.jar
 cd ../../UserConfirmation_Frontend/build && start python -m http.server 8002
 start java -jar Forgotpassword_Backend/target/Forgotpassword_Backend.jar
 cd ../../forgotpassword_frontend/build && start python -m http.server 8010
 start java -jar DataRetrievalService_BackEnd/target/DataRetrievalService_BackEnd.jar
 start java -jar LoginService_BackEnd/target/LoginService_BackEnd.jar
 cd ../../LoginService_Frontend/build && start python -m http.server 8014
 start java -jar ChangePasswordService_Backend/target/ChangePasswordService_Backend.jar
 cd ../../ChangePasswordService_Frontend/build && start python -m http.server 8016
 start java -jar Edit_Profile_Backend/target/Edit_Profile_Backend.jar
 cd ../../Edit_Profile_Frontend/build && start python -m http.server 8019
 start java -jar Admin_Backend/target/Admin_Backend.jar
 cd ../../Admin_Frontend/build && start python -m http.server 8021
