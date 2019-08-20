import React, { Component } from 'react';
// import { Link } from 'react-router-dom';
// import history from '../history';
import Recaptcha from 'react-recaptcha';
// import Axios from './Axios';


class RegistrationPage extends Component {

  constructor() {
    super();
    this.state = {
      users: {
        firstName: "",
        lastName: "",
        emailID: "",
        phoneNo: "",

        passwordHistory: {
          pwd1: ""
        },
        securityAns: {
          securityQueID1: 1,
          securityQueID2: 2,
          securityAnsID1: "",
          securityAnsID2: ""
        }
      },
      allcorrect: true,
      captchaver: false,

      fullList: [
        {
          questionID: 1,
          question: "What is your favourite sport?"
        },
        {
          questionID: 2,
          question: "What is your Dads name"
        },
        {
          questionID: 3,
          question: "Where are you from"
        },
        {
          questionID: 4,
          question: "What is your maidens name"
        },
        {
          questionID: 5,
          question: "Favourite Cricketer"
        }
      ],
      securityQuestion1: [],
      securityQuestion2: []


    };

    this.recaptchaLoaded = this.recaptchaLoaded.bind(this);
    this.verifyCallback = this.verifyCallback.bind(this);
  }

  componentDidMount() {
    this.filterQuestion(1, 3);
  }

  userDataEventHandler = (event) => {
    const newUsers = {};
    newUsers[event.target.name] = event.target.value;
    this.setState({ users: { ...this.state.users, ...newUsers } });
  }

  PasswordEventHandler = (event) => {
    this.setState({ users: { ...this.state.users, passwordHistory: { pwd1: event.target.value } } });
  }

  ConfirmPasswordEventHandler = (event) => {
    if (this.state.users.passwordHistory.pwd1 === event.target.value)
      console.log("same");
    else
      console.log("diff");
  }

  validate = (event) => {

    console.log(this.state);
    this.props.history.push('/home');

    // this.state.allcorrect = true;

    // // code to validate all input cases

    // if (this.state.allcorrect && window.confirm("Are you sure all details are correct") && this.state.captchaver) {
    //   Axios.auth.post(this.state.users);
    //   this.props.history.push({
    //     pathname: '/home',
    //     state: this.state
    //   })
    // }

  }

  recaptchaLoaded() {
    console.log('captcha has loaded');
  }

  verifyCallback(response) {
    if (response) {
      this.setState({captchaver : true});
    }
  }


  submit() {
    alert("submit");
  }


  filterQuestion = (questionID, question) => {

    let list = this.state.fullList;
    list = this.state.fullList.filter((list) => {
      return list.questionID !== parseInt(questionID)
    }).map((list) => { return list });

    if (question === 1) {
      this.setState({ users: { ...this.state.users, securityAns: { securityQueID1: questionID } }, securityQuestion2: list });
    }

    else if (question === 2)
      this.setState({ users: { ...this.state.users, securityAns: { securityQueID2: questionID } }, securityQuestion1: list });

    else {
      this.setState({ securityQuestion1: this.state.fullList });
      this.setState({ securityQuestion2: list });
    }

  }

  securityAnswers = (answer, answerID) => {

    if (answerID === 1)
      this.setState({ users: { ...this.state.users, securityAns: { securityAnsID1: answer } } });

    else if (answerID === 2)
      this.setState({ users: { ...this.state.users, securityAns: { securityAnsID2: answer } } });
  }


  render() {

    return (

      <form onSubmit={this.validate}>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label" >FirstName</label>
          <div className="col-sm-4">
            <input type="text" className="form-control" placeholder="FirstName" onChange={this.userDataEventHandler} name="firstName" value={this.state.users.firstName} />
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">LastName</label>
          <div className="col-sm-4">
            <input type="text" className="form-control" placeholder="LastName" name="lastName" onChange={this.userDataEventHandler} value={this.state.users.lastName} />
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">EmailID</label>
          <div className="col-sm-4">
            <input type="emailID" className="form-control" placeholder="EmailID" name="emailID" onChange={this.userDataEventHandler} value={this.state.users.emailID} />
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">PhoneNo</label>
          <div className="col-sm-4">
            <input type="number" className="form-control" placeholder="PhoneNo" name="phoneNo" onChange={this.userDataEventHandler} value={this.state.users.phoneNo} />
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">Password</label>
          <div className="col-sm-4">
            <input type="password" className="form-control" placeholder="Password" name="pwd1" onChange={this.PasswordEventHandler} value={this.state.users.passwordHistory.pwd1} />
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">Confirm Password</label>
          <div className="col-sm-4">
            <input type="text" className="form-control" placeholder="Confirm Password" name="confirmPassword" onChange={this.ConfirmPasswordEventHandler} />
          </div>
        </div>


        <div className="form-group row">
          <label className="col-sm-1 col-form-label">Security Question 1</label>
          <div className="col-sm-3">
            <select className="security" name="securityQueID1" onChange={(e) => this.filterQuestion(e.target.value, 1)}>
              {this.state.securityQuestion1.map(questions =>
                <option key={questions.questionID} value={questions.questionID}> {questions.question} </option>
              )}
            </select>
          </div>

          <div className="col-sm-4">
            <input type="text" name="securityAnsID1" value={this.state.users.securityAns.securityAnsID1} onChange={(e) => this.securityAnswers(e.target.value, 1)}></input>
          </div>
        </div>

        <div className="form-group row">
          <label className="col-sm-1 col-form-label">Security Question 2</label>
          <div className="col-sm-3">
            <select className="security" name="securityQueID2" onChange={(e) => this.filterQuestion(e.target.value, 2)}>
              {this.state.securityQuestion2.map(questions =>
                <option key={questions.questionID} value={questions.questionID}>{questions.question}</option>
              )}
            </select>
          </div>

          <div className="col-sm-4">
            <input type="text" name="securityAnsID2" value={this.state.users.securityAns.securityAnsID2} onChange={(e) => this.securityAnswers(e.target.value, 2)}></input>
          </div>
        </div>

        <Recaptcha
          sitekey="6LcE97EUAAAAAJ-MJMDdEt2fX5KDN_pjsdbCQ-pJ"
          render="explicit"
          onloadCallback={this.recaptchaLoaded}
          verifyCallback={this.verifyCallback}
        />
        <br />
        <button className="btn btn-primary" type="submit">Submit</button>

      </form>


    )
  }
}

export default RegistrationPage;
