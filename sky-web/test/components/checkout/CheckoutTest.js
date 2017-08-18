import React from 'react';
import { expect } from 'chai';
import { shallow } from 'enzyme';
import sinon from 'sinon';
import Checkout from './../../../src/components/checkout/Checkout';

describe('Checkout component test', () => {
  let wrapper;
  let checkout;

  beforeEach(() => {
    sinon.spy(window.localStorage.getItem);
    checkout = <Checkout/>
    wrapper = shallow(checkout);
  });

  it('should be rendered', () => {
    expect(wrapper.exists()).to.be.true;
  });
});
