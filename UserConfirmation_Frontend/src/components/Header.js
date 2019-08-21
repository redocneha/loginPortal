import React, { Component } from 'react';
import axios from 'axios';
import Loader from 'react-loader';
export default class Header extends React.Component {

    constructor(props) {
        super(props);
        this.state = { value: '', res: '', flag: false };

        /*setTimeout(function () {
            this.setState({
                flag: true
            })
        }.bind(this), 5000);
*/
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    handleSubmit(event) {
        //alert('A name was submitted: ' + this.state.value);
        event.preventDefault();
        //Fetch email from uid
        this.setState({flag:true})
        axios.get('http://localhost:8881/api/v1/sendmail/' + this.props.match.params.uid)
            .then(res => { console.log(res); this.temp = res; this.setState({ res: this.temp.data.response }); })
            .then(() => {
                setTimeout(function () {
                    this.setState({
                        flag: false
                    })
                }.bind(this), 5000);
                
            });

        /*
         <label>
                    UId:
                    <input type="text" value={this.state.value} onChange={this.handleChange}/>
                    </label>
        */
    }

    render() {
        console.log('In Header.js');
        return (
            <div >
                {
                    this.state.flag ?  <Loader 
                    color="blue"
                    /> : 
                    <div>
                        <form onSubmit={this.handleSubmit}>
                            <input type="submit" value="Submit" />
                        </form>
                        <h5>{this.state.res}</h5>
                    </div>
                }
            </div>

        );
    }



}