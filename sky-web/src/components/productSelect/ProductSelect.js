import React from 'react';
import ChannelList from './ChannelList';
import Basket from './Basket';
import requestAsync from 'superagent';

class ProductSelect extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      summary: [],
      sportsChannel: [],
      newsChannel: []
    }

    this.onCheckboxChange = this.onCheckboxChange.bind(this);
  }

  componentWillMount() {
      this.findLocation(window.localStorage.getItem("customerId"));
  }

  findLocation(id) {
    requestAsync.get('http://localhost:8080/api/location/')
      .query({ id: id })
      .end((error, response) => {
        if (!error && response) {
          this.findChannels(response.body.location);
        } else {
          console.log('Error: ' + error);
        }
      }
    );
  }

  findChannels(location) {
    requestAsync.get('http://localhost:8080/api/channels/')
      .query({ location: location})
      .end((error, response) => {
        if (!error && response) {
          this.setState({sportsChannel: response.body.sportsChannels,
            newsChannel: response.body.newsChannels});
        } else {
          console.log('Error: ' + error);
        }
      }
    );
  }

  onCheckboxChange(e) {
    if(e.target.checked) {
      var array = this.state.summary;
      array.push(e.target.value);
      this.setState({summary:array});
    }
    else {
      var array = this.state.summary;
      var index = array.indexOf(e.target.value)
      array.splice(index, 1);
      this.setState({summary:array});
    }
  }

  render() {
    return(
      <div className="container">
        <ChannelList title='Sports' channels={this.state.sportsChannel}
          onCheckboxChange={this.onCheckboxChange}/>
        <ChannelList title='News' channels={this.state.newsChannel}
          onCheckboxChange={this.onCheckboxChange}/>
        <Basket summary={this.state.summary} />
        </div>
    );
  }
}

export default ProductSelect;
