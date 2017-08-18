import React from 'react';
import { expect } from 'chai';
import { shallow } from 'enzyme';
import Basket from './../../../src/components/productSelect/Basket';

describe('Basket component test', () => {
  let wrapper;
  let basket;

  let summary = [ 'Test Channel' ];

  beforeEach(() => {
    basket = <Basket summary={summary}/>
    wrapper = shallow(basket);
  });

  it('should be rendered', () => {
    expect(wrapper.exists()).to.be.true;
  });

  it('should have summary of channels', () => {
    expect(wrapper.find('p').text()).to.equal(summary[0]);
  });

  it('should have button rendered', () => {
    expect(wrapper.find('button').exists()).to.be.true;
  });
});
