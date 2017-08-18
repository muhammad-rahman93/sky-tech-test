import React from 'react';
import { expect } from 'chai';
import { shallow } from 'enzyme';
import sinon from 'sinon';
import ProductSelect from './../../../src/components/productSelect/ProductSelect';

describe('ProductSelect component test', () => {
  let wrapper;
  let productSelect;

  beforeEach(() => {
    sinon.spy(window.localStorage.getItem);
    productSelect = <ProductSelect/>
    wrapper = shallow(productSelect);
  });

  it('should be rendered', () => {
    expect(wrapper.exists()).to.be.true;
  });
});
