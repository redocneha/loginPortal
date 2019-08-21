import React from 'react';
import '../App.css';
//import {Button , div, label, Input, Form , FormGroup}
//from 'reactstrap';
import Axios from 'axios';
//import { browserHistory } from 'react-router';
//import Axios from 'axios';
// import {FacebookLoginButton} from 'react-social-login-buttons';
import { BrowserRouter as Router, Link } from 'react-router-dom';
//import Welcome from '../components/Welcome'
//import index from '/index'

class Forms extends React.Component {

  constructor() {
    super();
    this.state = {
      username: '',
      hpassword: '',
      fields: {
        username: '',
        hpassword: ''
      },
      errors: {},
      // userObject: {}
      userObject: {
        userID: '',
        passwordHistory: {
          pwd1: ''
        }
      },
      emailIDObject: {
        emailID: '',
        passwordHistory: {
          pwd1: ''
        }
      }

    }
    // this.sendData=this.sendData.bind(this)
    this.eventhandler = this.eventhandler.bind(this);
    this.user = this.user.bind(this);
    this.clear = this.clear.bind(this);
    this.validateEmailorUserID = this.validateEmailorUserID.bind(this);
    this.validateForm = this.validateForm.bind(this);
    this.axiosReponse = this.axiosReponse.bind(this);
  }

  eventhandler(e) {
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
    let emailIDObject = this.state.emailIDObject;
    let fields = this.state.fields;
    let errors = {};
    let formIsValid = true;
    let flag = this.validateEmailorUserID(fields.username);

    if (!fields["username"]) {
      formIsValid = false;
      errors["username"] = "*This Field can not be empty";
    }
    if (!flag) {
      userObject["userID"] = this.state.fields.username;
      userObject.passwordHistory["pwd1"] = this.state.fields.hpassword;

      if (typeof fields["username"] !== "undefined") {
        if (!fields["username"].match(/^[0-9]*$/)) {
          formIsValid = false;
          errors["username"] = "*Please enter valid userID only.";
        }
      }
    }
    if (flag) {
      emailIDObject["emailID"] = this.state.fields.username;
      emailIDObject.passwordHistory["pwd1"] = this.state.fields.hpassword;
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
  axiosReponse(url, obj) {
    //console.log(`axiosReposne Called with url: ${url} and Object :${obj.passwordHistory.pwd1}`)
    Axios.post(url, obj)
      .then(
        res => {
          console.log(res.data.message)
          
      if (res.data.message === "Authenticated") {
        alert(res.data.message)
      }
      else if((res.data.message === "Not a confirmed user")) {
        alert(res.data.message)
      }
      else if((res.data.message === "Incorrect Password")) {
        alert(res.data.message)
      }
      else{
        alert(res.data.message)
      }
         }

      ).catch(error => {
        console.log(error.response)
      });
  }


  user(arg) {
    arg.preventDefault()
    //let url = "http://10.150.176.60:8013/api/authenticate";
    let url = "localhost:8013/api/authenticate"
    if (this.validateForm()) {
      console.log(`email: ${this.state.emailIDObject.emailID}`)
      console.log(`EmailID Password: ${this.state.emailIDObject.passwordHistory.pwd1}`)
      console.log(`UserID: ${this.state.userObject.userID}`)
      console.log(`UserIDPassword: ${this.state.userObject.passwordHistory.pwd1}`)

      if (this.validateEmailorUserID(this.state.fields.username)) {
        console.log("In email axios method")
        
        this.axiosReponse(url, this.state.emailIDObject)                                    

      }
      else {
        console.log("In User axios method")
      //this.axiosReponse(url, this.state.userObject);
      this.axiosReponse(url, this.state.userObject)
      }



      let userObject = { passwordHistory: {} }
      let emailIDObject = { emailID: '', passwordHistory: { pwd: '' } }
      
      userObject["userID"] = "";
      userObject["passwordHistory"]["pwd1"] = "";

   
      this.setState({
        userObject: userObject,
        emailIDObject: emailIDObject,
        fields:{
        username: '',
        hpassword: ''
      }});
    }

  }
  // showErrorMsg() {

  //   return (
  //     document.getElementById("showError").innerHTML = "Confirm Your Email"
  //   )
  // }
  // redirectPage() {
  //   return (
  //     document.getElementById("showError").innerHTML = "You are a valid User")
  // }
  clear = () => {

    // this.setState({
    //   username: '',
    //   hpassword: ''
    // })
  }


  render() {
    //console.log(this.state);
    return (

      <form id="form" action="/">
        <div className="text-center">
          <h1 className="text-center">Login Page</h1>


          <label>UserId/Email:</label>
          <input type="text" name="username" value={this.state.fields.username} ref="clearUname" onChange={this.eventhandler} placeholder="UserId/Email" required></input>
          <div className="errorMsg">{this.state.errors.username}</div>
          <br />
          <br />
          <label>Password:</label>
          <input type="password" name="hpassword" value={this.state.fields.hpassword} ref="clearPwd" onChange={this.eventhandler} placeholder="Password" required></input>
          <div className="errorMsg">{this.state.errors.hpassword}</div>
          <br />
          <br />
          <button type="submit" onClick={this.user} >Log in</button>
          <button onClick={this.clear} >Reset</button>

          {/* <div className="text-center pt-3" >or continue with Social Login</div>
        <FacebookLoginButton className="mt-3 mb-3"/> */}
        </div>

        <Router>
          <div className="text-center">
            <Link to={'./Welcome'}>Sign Up</Link>
            {/* <button  onClick="welcome">Sign Up</button> */}
            <span className="p-2">|</span>
            <a href="localhost/8010/forgotpassword">Forgot Password</a>
            {/* http://10.150.176.241:3003/forgotpassword */}
            <br />
            <span id="showError"></span>


          </div>

        </Router>
        }
        
    </form>

    )
  }
}

export default Forms;
