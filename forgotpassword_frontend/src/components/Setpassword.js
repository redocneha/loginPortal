import React from 'react';
import Axios from 'axios';
import { Link} from 'react-router-dom';
export default class Setpassword extends React.Component{

    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this)
        this.click=this.click.bind(this);
        this.checkScore=this.checkScore.bind(this); 
        this.validatePassword = this.validatePassword.bind(this);
        this.state = {
          
          password: "",
          confirmed: false,
          confirmPassword: "",
          isConfirming: false,
          status:null,
          value:null
        };
      }

    
    validatePassword(){
        this.copy();
        console.log("vpwd");
       let  pwd = document.getElementById("t1").value;
       let  cpwd = document.getElementById("t2").value;
      
    
       if (pwd.length===0) 
         document.getElementById("msg1").innerText="Please enter password";
       else
         document.getElementById("msg1").innerText="  ";
       if (cpwd.length===0)
          document.getElementById("msg2").innerText="Please enter confirm password";
       else
          document.getElementById("msg2").innerText="  ";  
          
          
        // If confirm password not entered 
    if (cpwd !==pwd  && pwd.length!==0 && cpwd.length!==0)   
      document.getElementById("msg3").innerText="Password did not match: Please try again...";
    else if (pwd===cpwd && pwd.length>0){

        document.getElementById("msg3").innerText="  ";
        document.getElementById("msg2").innerText=this.checkScore();
    }
       
    }
   
    copy(){
        window.event.preventDefault();
        if (window.event.ctrlKey){
        if (window.event.keyCode === 86) {
            console.log("copy");
      //  document.getElementById("t1").value = " ";
        document.getElementById("t2").value = "";
      

        }
    }
}
    checkScore(){
        let  cpwd = document.getElementById("t2").value;
       
       // console.log(pwd);
        let pass= cpwd;
        var score = 0;
        
        // award every unique letter until 5 repetitions
     var letters = new Object();
         for (var i=0; i<pass.length; i++)  {
         letters[pass[i]] = (letters[pass[i]] || 0) + 1;
         score += 5.0 / letters[pass[i]];
     }
       
     
     // bonus points for mixing it up
     var variations = {
         digits: /\d/.test(pass),
         lower: /[a-z]/.test(pass),
         upper: /[A-Z]/.test(pass),
         nonWords: /\W/.test(pass),
     }
 
     let  variationCount = 0;
     for (var check in variations) {
         variationCount += (variations[check] === true) ? 1 : 0;
     }
     score += (variationCount - 1) * 10;
 
     score = parseInt(score);  
     if (score > 80)
       return "Strong";
     if (score > 60)
        return "Medium";
     if (score >= 30)
        return "Weak";

       return "very weak";
  
    }  
    handleChange(e){
        this.setState({value:e.target.value});
      }
      click(){
        let data={
            password:this.state.value,
            email:this.props.email
        }
        Axios.post("http://10.150.176.126:8009/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
        //Axios.post("http://192.168.43.237:8076/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
        
      }
    render (){
        return(
        <div className="password_reset">
        
        <pre>    
        Password :          <input type="password" name="password" id="t1"   onChange={this.handleChange} onKeyUp={this.validatePassword} ></input><span id="msg1">  </span><br/><br/>
        Confirm Password:   <input type="password" name="cpassword" id="t2"   onKeyUp={this.validatePassword} ></input><span id="msg2">  </span><br/>
       
        <span id="">  </span>

        <input type="submit" value="Submit" onClick={this.click}></input> <input type="reset" value="Reset"></input><span id="msg3">  </span>
  <h6>{this.state.status}</h6>
  {this.state.status==='true'?<a href="http://10.150.121.200:3000/login">Login</a>:null}
        </pre>
       

        </div>
        )
    }
}
