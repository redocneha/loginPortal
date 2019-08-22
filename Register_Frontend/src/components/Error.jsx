import React, { Component } from 'react'
import RegistrationPage from './RegistrationPage';

class Error extends Component {
  constructor(props){
    super(props);
    this.state={};
  }
  render() {
    return (
      <div>
        <h1>User Already Exists</h1>
        <br/><br/>
        <RegistrationPage/>
      </div>
    )
  }
}

export default Error;