import React, {Component} from 'react';
import '../App.css';

//import Axios from 'axios';


class Welcome extends Component {

    constructor(){
      super();
      this.state={}
    
    
}



render()
{
  return (
   // console.log(this.props.userData),
    <form className="welcome-page" >
        
    <h1 className="Text-center">Welcome Page</h1>
    <h2 className="Text-center">Welcome User</h2>
   
      <button>Update Profile</button>
      <button> Profile</button>

    </form>

  )
}
}
export default Welcome;