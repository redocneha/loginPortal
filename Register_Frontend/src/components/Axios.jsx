import axios from 'axios';

const axcreate =  axios.create({
    baseURL: "http://localhost:8005/api/v1/users",
    responseType: "json"
})

export default{
    auth: {
        getSecurityQuestions(){
            return axcreate.get("/securityquestions");
        },
        postusers(data){
            return axcreate.post("/register",data);
        }
    }
}
