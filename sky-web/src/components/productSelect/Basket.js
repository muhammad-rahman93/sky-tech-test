import React from 'react';
import { Link } from 'react-router-dom';

const Basket = ( { summary } ) => (
  <div className="col-sm-4">
    <h2>Basket</h2>
      {
        summary.map(entry => (
           <p key={entry}>{entry}</p>
         ))
     }

    <Link to={{ pathname: '/checkout', state: { summary: summary }}}>
      <button className="btn btn-primary">Checkout</button>
    </Link>
  </div>
);

export default Basket;
