import React from 'react';
import Header from './components/Header';
import ConfirmMail from './components/ConfirmMail';
import { shallow, mount, render } from 'enzyme';

describe('Header Component Loading', () => {

  // make our assertion and what we expect to happen 
  it('should render without throwing an error', () => {
    expect(shallow(<Header />).find('div.activatebtn').exists()).toBe(true)
  })


  it('calls onSubmit function when form is submitted', () => {

    const validate = jest.fn();

    const wrapper = mount(<form onSubmit={validate} />);

    const form = wrapper.find('form');

    form.simulate('submit');

    expect(validate).toHaveBeenCalledTimes(1);

  })


})

