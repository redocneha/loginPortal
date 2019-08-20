import React,{Component} from 'react';
import axios from 'axios';

export default class EditProfile extends Component {

    constructor(){
        super();
        
        this.state={
                user:{
                  id: '',
                  fname:'',
                  lname:'',
                  role:'',
                  email: '' ,
                  phone: '',
                  address:''
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
      let data={
            fname:'demo',
            lname:'user',
            email:'demo@demo.demo',
            phone:'88888888'
        }
        this.setState({
            user: data
        })
    	/*axios.get('http://localhost:8091/10')
	      .then(res => {
	        const data = res.data;
	        console.log(data);
	        this.setState({
	        	user: data
	        })
	      })*/
    }

    submitHandler = event =>{
        event.preventDefault();
        console.log("submited*******");
    }

   updateFields(e,field){
    let data=this.state.user;
    console.log(data);
    if(field==="fname"){
        data.fname=e.target.value;
    }
    else if( field==="lname"){
        data.lname=e.target.value;
    }
    else if(field==="phone"){
        data.phone=e.target.value;
    }
    this.setState({user:data});

   }

   update(e){
   // e.preventDefault();
   console.log(this.state.user);
    const user1 = {
          id:10,
          fname:this.state.user.fname,
          lname:this.state.user.lname,
          role:'user',
          email: this.state.user.email ,
          phone: this.state.user.phone,
          address:'dsad'
    }
    console.log(this.state.user.fname);
    /*axios.post('http://localhost:8091/updateUser', user1)
    .then(res => console.log(res.data));*/
   // $('#myModal').hide();
   // $('#myModal').modal('toggle');
    this.mask();
    alert('Profile Updated Successfully');
    // console.log(this.state.log);
    // axios.post('http://localhost:8091/updateUser', 
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
    //axios.post('http://localhost:8091/sendOtp', { email: this.state.user.email });
   }

    render(){
        return  (
            <div>
              <form onSubmit={this.submitHandler}>
                      First name:<br/>
                  <input type="text" name="firstname" value={this.state.user.fname} disabled={this.state.disabled} 
                  onChange={(e)=> this.updateFields(e,"fname")} />
                  <br/>
                      Last name:<br/>
                  <input type="text" name="lastname" value={this.state.user.lname} disabled={this.state.disabled} 
                  onChange={(e)=> this.updateFields(e,"lname")}/>
                  <br/>
                  Email:<br/>
                  <input type="text" name="email" value={this.state.user.email} disabled/>
                  <br/>
                  Phone Number:<br/>
                  <input type="text" name="phonenumber" value={this.state.user.phone} disabled={this.state.disabled}
                  onChange={(e)=> this.updateFields(e,"phone")}/>
                  <br/>
                      <br/><br/>
                  <button onClick={()=>this.mask()}>EDIT!</button>
              </form>
              <button type="button" className="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onClick={()=>this.pingForOtp()} >SUBMIT</button>
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