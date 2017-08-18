import React from 'react';
import { expect } from 'chai';
import { shallow } from 'enzyme';
import sinon from 'sinon';
import ChannelList from './../../../src/components/productSelect/ChannelList';

describe('ChannelList component test', () => {
  let wrapper;
  let channelList;
  let onCheckboxChange;

  let title = 'Test Title';
  let channels = [ 'Test Channel' ];

  const sandbox = sinon.sandbox.create();

  beforeEach(() => {
    onCheckboxChange = sandbox.stub();
    channelList = <ChannelList title={title} channels={channels}
      onCheckboxChange={onCheckboxChange}/>
    wrapper = shallow(channelList);
  });

  it('should be rendered', () => {
    expect(wrapper.exists()).to.be.true;
  });

  it('should have title', () => {
    expect(wrapper.find('h2').text()).to.equal(title);
  });

  it('should have channel', () => {
    expect(wrapper.find('p').text()).to.equal(channels[0]);
  });

  it('should call onChange method on input click', () => {
    wrapper.find('input').first().simulate('change', {});
    sinon.assert.calledOnce(onCheckboxChange);
  });
});
