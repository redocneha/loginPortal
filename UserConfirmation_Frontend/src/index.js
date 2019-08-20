import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import Header from './components/Header';
import ConfirmMail from './components/ConfirmMail';
import {BrowserRouter as Router, Route, Link } from "react-router-dom";

const router = (
    <Router>
        <div>
            <Route path="/confirmuser/:uid" component={Header}/>
            <Route path="/confirmmail/:uid" component={ConfirmMail}/>
        </div>
    </Router>
)

ReactDOM.render(router, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();