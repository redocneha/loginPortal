import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class RegisterButton extends Component {
  
  
  render() {
    return (
      <div>
        <br /><br />
        <Link to="/register">
          <button className="btn btn-primary"> Register</button></Link>
      </div>
    )
  }
}
