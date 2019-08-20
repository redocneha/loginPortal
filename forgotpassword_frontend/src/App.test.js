import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { shallow,mount } from 'enzyme';
import {sum} from './components/math';
import ForgotPassword from './components/ForgotPassword';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);
  ReactDOM.unmountComponentAtNode(div);
});

describe('Examining the syntax of Jest tests', () => {
   
  it('sums numbers', () => {
      expect(1 + 2).toEqual(3);
      expect(2 + 2).toEqual(4);
   });

   it('sum numbers from function',()=>{
      expect(sum(2,31)).toEqual(33);
   });
});

describe('First React component test with Enzyme', () => {
  it('renders without crashing', () => {
     shallow(<App />);
   });
});

describe('Test Button component', () => {
  it('Test click event', () => {
    const button = mount(<ForgotPassword/>);
    const ema = button.find('input').at(0);
    //ema.value="mamidid@gmail.com";
    expect(button.state().alltrue).toEqual(true);
    ema.instance().value="mamid";
    ema.simulate('change');
    ema.simulate('keyup');
    console.log(button.state());
    button.find('.bbb').simulate('click');
    expect(button.state().alltrue).toEqual(false);
  });
});

describe('Test Button component', () => {
  it('Test click event', () => {
    const button = mount(<ForgotPassword/>);
    const ema = button.find('input').at(0);
    //ema.value="mamidid@gmail.com";
    expect(button.state().alltrue).toEqual(true);
    ema.instance().value="mamidid@gmail.com";
    ema.simulate('change');
    ema.simulate('keyup');
    console.log(button.state());
    button.find('.bbb').simulate('click');
    expect(button.state().alltrue).toEqual(true);
  });
});

it('test field event',()=>{
  const email=mount(<ForgotPassword/>);
  const e = email.find('input').at(0);
  expect(e.instance().value).toEqual("");
  e.instance().value="mamidid@gmail.com";
  expect(e.instance().value).toEqual("mamidid@gmail.com");
});