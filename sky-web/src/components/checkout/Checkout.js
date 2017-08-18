import React from 'react';

class Checkout extends React.Component {
  render() {
    var summary;

    if(this.props.location !== undefined ) {
      summary = this.props.location.state.summary;
    } else {
      summary = [];
    }

    return (
      <div className="container">
        <h2>Confirmation</h2>
        <h4>Customer ID</h4>
        <p>{window.localStorage.getItem("customerId")}</p>
        <h4>Channel summary</h4>
        {
          summary.map(entry => (
            <p key={entry}>{entry}</p>
           ))
        }
       </div>
     );
  }
}

export default Checkout;
