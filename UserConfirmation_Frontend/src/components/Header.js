import React,{Component} from 'react';
import axios from 'axios';

export default class Header extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {value: '', res :''};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleSubmit(event) {
        //alert('A name was submitted: ' + this.state.value);
        event.preventDefault();
        //Fetch email from uid
        axios.get('http://localhost:8881/api/v1/sendmail/'+ this.props.match.params.uid)
        .then(res => {console.log(res);this.temp = res;this.setState({res : this.temp.data.response});});

        /*
         <label>
                    UId:
                    <input type="text" value={this.state.value} onChange={this.handleChange}/>
                    </label>
        */
    }

    render(){
        console.log('In Header.js');
        return  (
            <div >
                <form onSubmit={this.handleSubmit}>
                    <input type="submit" value="Submit" />
                </form>
                <div>
                    <h5>{this.state.res}</h5>
                </div>
            </div>

        );
    }
    
    

}