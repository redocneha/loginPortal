import React from 'react';
import './ForgotPassword.css';
import Axios from 'axios';
import Methods from './Methods';

export default class ForgotPassword extends React.Component{
    constructor(){
        super();
        this.check = this.check.bind(this);
        this.click = this.click.bind(this);
        this.handleChange = this.handleChange.bind(this)
        this.state={
            status:"false",
            alltrue:true,
            value:null,
            msg:null
        }
        
    }
    check(ev){
        var e=this.state.value;
        var v = this.validateEmail(e);
        if(v){
        
            this.setState({msg:""})
        }
        else{
            
            this.setState({
                alltrue:false,
                msg:'please enter correct email'
            });
        }

    }
    validateEmail(email) {
        return email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
    }
      click(){
          
        let data={
            email:this.state.value
        }
        Axios.post("http://10.150.176.126:8009/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter an email registered'}));
        //Axios.post("http://192.168.43.237:8076/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter an email registered'}));
        
      }
      handleChange(e){
        this.setState({value: e.target.value});
      }
    render(){
        return(
            <div>
                <h2>Please enter your email to recover the password</h2>
                    <label>Email:   </label> 
                    <input type="email" name="email" id="email" onKeyUp={this.check} onChange={this.handleChange}></input><span id="msg">{this.state.status==='false'?this.state.msg:''}</span><br></br>
                    <input className="btn btn-primary bbb" type="submit" onClick={this.click}></input>
                    {this.state.status==='true'?<Methods email={document.getElementById('email').value}/>:this.state.msg}
            </div>
        );
    }
}