import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {Router, Route} from 'react-router-dom';
import history from './history';
import RegistrationPage from './components/RegistrationPage';
import Home from './components/Home';


const router = (
    <Router history = {history}>
        <ul>
            <Route exact path="/" component={App} /> <br />
            <Route exact path="/register" component={RegistrationPage} /> <br />
            <Route exact path="/home" component={Home} /> <br />
        </ul>
    </Router>
)


ReactDOM.render(
    router, 
    document.getElementById('root'));
