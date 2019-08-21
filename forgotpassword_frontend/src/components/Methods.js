import React from 'react';
import Axios from 'axios';
import Securityquestion from './Securityquestions';
import OTPtoMail from './OTPtoMail';

export default class Methods extends React.Component{
    constructor(props){
      super(props)
      this.click = this.click.bind(this)
      this.state={
          data:null,
          checked:"0"
      }
    }
    click(){
        console.log("hais")
        var cc = document.getElementsByName("method");
        var i;
        var data;
        console.log(cc)
        for(i=0;i<cc.length;i++){
            if(cc[i].checked){
                data={
                    choice:cc[i].value,
                    email:this.props.email
                }
            }
        }
        Axios.post("http://localhost:8009/forgotpassword/mts",data).then(res => this.setState({data:res.data,checked:data.choice}) )
       //Axios.post("http://192.168.43.237:8076/forgotpassword/mts",data).then(res => this.setState({status:res.data,checked:data.choice}));
    }
    render(){
        return(
            <div>
               
                   <input type="radio" name="method" value="1" id="1"/>Send link to the email<br/>
                   <input type="radio" name="method" value="2" id="2" />Send OTP to mail<br/>
                   <input type="radio" name="method" value="3" id="3"/>Security Questions<br/>
                   <input type="email"  value={this.props.email} name="email" id="email" hidden></input>
                   <input type="button" onClick={this.click} value="SUBMIT"></input>
                    {this.state.checked==="1"?<Securityquestion ques1={this.state.data.question1} ques2={this.state.data.question2}/>:''}
                    {this.state.checked==="2"?<OTPtoMail/>:null}
                    {this.state.checked==="3"?<Securityquestion email={this.props.email} ques1={this.state.data.question1} ques2={this.state.data.question2}/>:''}
   
            </div>
        );
    }
}