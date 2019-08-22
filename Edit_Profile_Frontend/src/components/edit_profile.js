import React,{Component} from 'react';
import axios from 'axios';

export default class EditProfile extends Component {

    constructor(){
        super();
        
        this.state={
                user:{
                  userid: '',
                  first_name:'',
                  last_name:'',
                 // user_role:'',
                  emailid: '' ,
                  phone_no: '',
                 // address:''
                },       
                disabled:true
        }

    }

    mask(){
        console.log("aaaya "+ this.state.disabled);
        this.setState({
            user:this.state.user,
            disabled:!this.state.disabled
        })
    }

    componentDidMount(){
     /* let data={
            fname:'demo',
            lname:'user',
            email:'demo@demo.demo',
            phone:'88888888'
        }
        this.setState({
            user: data
        })*/
    	axios.get('http://localhost:8018/4')
	      .then(res => {
	        const data = res.data;
	        console.log(data);
	        this.setState({
	        	user: data
	        })
	      })
    }

    submitHandler = event =>{
        event.preventDefault();
        console.log("submited*******");
    }

   updateFields(e,field){
    let data=this.state.user;
    console.log(data);
    if(field==="first_name"){
        data.first_name=e.target.value;
    }
    else if( field==="last_name"){
        data.last_name=e.target.value;
    }
    else if(field==="phone_no"){
        data.phone_no=e.target.value;
    }
    this.setState({user:data});

   }

   update(e){
   // e.preventDefault();
   console.log(this.state.user);
    const user1 = {
          userid:4,
          first_name:this.state.user.first_name,
          last_name:this.state.user.last_name,
         // user_role:'user',
          emailid: this.state.user.emailid ,
          phone_no: this.state.user.phone_no,
         // address:'dsad'
    }
    console.log(this.state.user.first_name);
    axios.post('http://localhost:8018/updateUser', user1)
    .then(res => console.log(res.data));/*
   $('#myModal').hide();
   // $('#myModal').modal('toggle');
   */ this.mask();
    alert('Profile Updated Successfully');
    // console.log(this.state.log);
    // axios.post('http://localhost:8018/updateUser', 
    //     { id:2,
    //       email: this.state.email ,
    //       fname:this.state.fname,
    //       lname:this.state.lname,
    //       role:'user',
    //       phone: this.state.phone,
    //       address:'dsad'
    //     });
   }

   pingForOtp(){
   // axios.post('http://localhost:8091/sendOtp', { emailid: this.state.user.emailid });
   }

    render(){
        return  (
            <div className="container row col-lg-4">

          <br/>
              <form onSubmit={this.submitHandler}>
              <div className="form-group row">
                <label  className="col-sm-3 col-form-label">First Name:</label>
                <div className="col-sm-9">
                  <input type="text" className="form-control" name="first_name" value={this.state.user.first_name} disabled={this.state.disabled} 
                              onChange={(e)=> this.updateFields(e,"first_name")} />
                </div>
              </div>
              <div className="form-group row">
                <label  className="col-sm-3 col-form-label">Last Name:</label>
                <div className="col-sm-9">
                  <input type="text" className="form-control" name="last_name" value={this.state.user.last_name} disabled={this.state.disabled} 
                    onChange={(e)=> this.updateFields(e,"last_name")}/>
                </div>
              </div>
              <div className="form-group row">
                <label  className="col-sm-3 col-form-label">Email:</label>
                <div className="col-sm-9">
                  <input type="email" className="form-control" name="emailid" value={this.state.user.emailid} disabled/>
                </div>
              </div>
              <div className="form-group row">
                <label  className="col-sm-3 col-form-label">Phone Number:</label>
                <div className="col-sm-9">
                  <input type="text" className="form-control" name="phone_no" value={this.state.user.phone_no} disabled={this.state.disabled}
                  onChange={(e)=> this.updateFields(e,"phone_no")}/>
                </div>
              </div>
                  <button onClick={()=>this.mask()} className="btn btn-default margin ">EDIT!</button>
                  <button type="button" className="btn btn-primary" data-toggle="modal" data-target="#myModal" onClick={()=>this.pingForOtp()} >SUBMIT</button>
              </form>
              <div className="row col-lg-12">
                <a href="http://localhost:8014/welcome"> redirect to homepage</a>
              </div>
              <div id="myModal" className="modal fade" role="dialog">
                  <div className="modal-dialog">
                      <div className="modal-content">
                      <div className="modal-header">
                          <button type="button" className="close" data-dismiss="modal">&times;</button>
                          <h4 className="modal-title">Enter OTP</h4>
                      </div>
                      <div className="modal-body">
                          <p>Please Enter the OTP that you have received via mail</p>
                          Enter OTP:<br/>
                               <input type="number" name="otp" />
                      </div>

                      <div className="modal-footer">
                          <button type="button" className="btn btn-default" onClick={(e)=>this.update(e)} data-dismiss="modal">Submit</button>
                          <button type="button" className="btn btn-default" data-dismiss="modal">Close</button>
                      </div>
                      </div>
                  </div>
                  </div>
                </div>
        );
    }
}