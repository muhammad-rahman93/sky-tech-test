import React from 'react';

const ChannelList = ({ title, channels, onCheckboxChange }) => (
  <div className="col-sm-4">
    <h2>{title}</h2>
    {
      channels.map(entry => (
        <p key={entry}><input type="checkbox" name={entry} value={entry}
          onChange={onCheckboxChange}/>{entry}</p>
       ))
     }
  </div>
);

export default ChannelList;
