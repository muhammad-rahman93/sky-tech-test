import React from 'react';
import { HashRouter, Switch, Route } from 'react-router-dom';
import ProductSelect from './../components/productSelect/ProductSelect';
import Checkout from './../components/checkout/Checkout';

class App extends React.Component {
  componentWillMount() {
    window.localStorage.setItem("customerId", "00001");
  }
  render() {
    return(
      <HashRouter>
        <Switch>
          <Route exact path="/" component={ProductSelect} />
          <Route exact path="/checkout" component={Checkout} />
        </Switch>
       </HashRouter>
    );
  }
}

export default App;
