import React, {Component} from 'react';
import '../App.css';
//import {Button , div, label, Input, Form , FormGroup}
//from 'reactstrap';
//import Axios from 'axios';
//import { browserHistory } from 'react-router';
//import Axios from 'axios';
// import {FacebookLoginButton} from 'react-social-login-buttons';

class Forms extends Component {

  constructor(){
    super();
    this.state={
      username:'',
      hpassword:'',
      fields: {username: '',
               hpassword:''
              },
      errors: {},
     // userObject: {}
     userObject :{userID:'',
                  hashedpwd:''
                  },
      emailIDObject:{emailID:'',
                    hashedpwd:''}             

    }
   // this.sendData=this.sendData.bind(this)
    this.eventhandler=this.eventhandler.bind(this);
    this.user = this.user.bind(this);
    this.clear=this.clear.bind(this);
    this.validateEmailorUserID=this.validateEmailorUserID.bind(this);
    this.validateForm=this.validateForm.bind(this);
  }

 eventhandler(e){
   //console.log(this.state);
   //this.setState({[e.target.name] : e.target.value})
   let fields = this.state.fields;
      fields[e.target.name] = e.target.value;
      this.setState({
        fields
      });

   
 }
 
 validateEmailorUserID(args) {
  var mailformat = /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/
  console.log(`User ${mailformat.test(args)}`)
  return mailformat.test(args) ? true : false
}



validateForm() {
  //let userObject = this.state.userObject;
  let userObject = this.state.userObject;
  let emailIDObject= this.state.emailIDObject;
  let fields = this.state.fields;
  let errors = {};
  let formIsValid = true;
  let flag = this.validateEmailorUserID (fields.username);

  if (!fields["username"]) {
    formIsValid = false;
    errors["username"] = "*This Field can not be empty";
  }
if(!flag) {
  userObject["userID"]= this.state.fields.username;
  userObject["hashedpwd"]= this.state.fields.hpassword;

  if (typeof fields["username"] !== "undefined") {
    if (!fields["username"].match(/^[0-9]*$/)) {
      formIsValid = false;
      errors["username"] = "*Please enter valid userID only.";
    }
  }
}
if(flag){
  emailIDObject["emailID"]= this.state.fields.username;
  emailIDObject["hashedpwd"]= this.state.fields.hpassword;
  if (typeof fields["username"] !== "undefined") {
    //regular expression for email validation
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    if (!pattern.test(fields["username"])) {
      formIsValid = false; 
      errors["username"] = "*Please enter valid email-ID.";
    }
  }
}
  
  if (!fields["hpassword"]) {
    formIsValid = false;
    errors["hpassword"] = "*This Field can not be empty";
  }

  if (typeof fields["hpassword"] !== "undefined") {
    if (!fields["hpassword"].match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
      formIsValid = false;
      errors["hpassword"] = "*Please enter secure and strong password.";
    }
  }

  this.setState({
    errors: errors,
    
  });
  return formIsValid;

}

  
  user(arg) {
    arg.preventDefault()  
   
      if (this.validateForm())  {
        console.log(`email: ${this.state.emailIDObject.emailID}`)
        console.log(`UserID: ${this.state.userObject.userID}`)
        console.log(this.validateForm.flag)
        if(this.validateEmailorUserID (this.state.fields.username)){
        console.log("In email axios method")
      //   Axios.post('http://10.150.176.110:8013/api/authenticate',this.state.emailIDObject)
      //   .then(res=>console.log(res.data
      //    )).catch(error => {
      //     console.log(error.response)
      // });
    }
      else{
        console.log("In User axios method")
      //   Axios.post('http://10.150.176.110:8013/api/authenticate',this.state.userObject)
      //   .then(res=>console.log(res.data
      //    )).catch(error => {
      //     console.log(error.response)
      // });
    }
      
         let userObject = {};
         let emailIDObject={};
         userObject["hpassword"] = "";
         userObject["userID"]="";
         emailIDObject["hpassword"] = "";
         emailIDObject["emailID"]="";
         this.setState({userObject:userObject,
                        emailIDObject:emailIDObject});
       // alert("Form submitted");
// this.setState({sendData: res.data}
        }
      }
  
//   sendData = () =>{
//     console.log(this.state.username,this.state.hpassword);
      
//  }
 



clear=()=>{
 
  this.setState({
    username:'',
    hpassword:''
   })
}

welcome(){
  console.log("welcome");
}

render()
{
  return (
   // console.log(this.props.userData),
    <form id="form" action="/">
    <div  className="text-center">    
    <h1 className="text-center">Login Page</h1>
    
    
          <label>Username:</label>
          <input  type="text" name="username" value={this.state.fields.username} ref="clearUname" onChange={this.eventhandler} placeholder="Username/Email" required></input>
          <div className="errorMsg">{this.state.errors.username}</div>
          <br/>
          <br/>
          <label>Password:</label>
          <input  type="password" name="hpassword" value={this.state.fields.hpassword} ref="clearPwd" onChange={this.eventhandler} placeholder="Password" required></input>    
          <div className="errorMsg">{this.state.errors.hpassword}</div>
          <br/>
          <br/>
        <button  type="submit" onClick= {this.user} >Log in</button>  
        <button  onClick={this.clear} >Reset</button>
        
        {/* <div className="text-center pt-3" >or continue with Social Login</div>
        <FacebookLoginButton className="mt-3 mb-3"/> */}
    </div>
      <div className="text-center">
        <a href='./Welcome'>Sign Up</a>
      {/* <button  onClick="welcome">Sign Up</button> */}
      <span className="p-2">|</span>
      <a  href="http://10.150.176.241:3003/forgotpassword">Forgot Password</a>
         
    </div>
    </form>

  )
}
}
export default Forms;
