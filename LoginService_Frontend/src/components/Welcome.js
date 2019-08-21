import React, {Component} from 'react';
import '../App.css';

//import Axios from 'axios';


class Welcome extends Component {

    constructor(){
      super();
      this.state={}
      this.routeChange = this.routeChange.bind(this);
    
}

routeChange() {
  let path = `/http://10.150.120.160:8016`;
  this.props.history.push(path);
}



render()
{
  return (
   // console.log(this.props.userData),
    <form className="welcome-page" >
        
    <h1 className="Text-center">Welcome Page</h1>
    
   
      <button  onClick={this.routeChange}>Update Profile</button>
      <a href='http://10.150.120.160:8016' >Change Password</a>
          
    </form>

  )
}
}
export default Welcome;