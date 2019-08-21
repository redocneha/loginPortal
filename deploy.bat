 start java -jar Register_Backend/target/Register_Backend.jar
 cd Register_Frontend/build && start python -m http.server 8006
 start java -jar UserConfirmation_Backend/target/UserConfirmation_Backend.jar
 cd ../../UserConfirmation_Frontend/build && start python -m http.server 8002
 REM start java -jar Forgotpassword_Backend/target/Forgotpassword_Backend.jar
 REM cd ../../forgotpassword_frontend/build && start python -m http.server 8010
 REM start java -jar DataRetrievalService_BackEnd/target/DataRetrievalService_BackEnd.jar
 REM start java -jar LoginService_BackEnd/target/LoginService_BackEnd.jar
 REM cd ../../LoginService_Frontend/build && start python -m http.server 8014
 REM start java -jar ChangePasswordService_Backend/target/ChangePasswordService_Backend.jar
 REM cd ../../ChangePasswordService_Frontend/build && start python -m http.server 8016
 REM start java -jar Edit_Profile_Backend/target/Edit_Profile_Backend.jar
 REM cd ../../Edit_Profile_Frontend/build && start python -m http.server 8019
 REM start java -jar Admin_Backend/target/Admin_Backend.jar
 REM cd ../../Admin_Frontend/build && start python -m http.server 8021
