import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import './App.css';
import Logs from "./components/Logs";
import Header from "./components/layouts/Header";
import Home from "./components/pages/Home";

class App extends Component {

  state = {
    logs: []
  }

  componentDidMount() {
    fetch('http://192.168.0.103:8080/logs/' /*'http://localhost:8080/logs/'*/)
      .then(res => res.json())
      .then((data) => {
        this.setState({ logs: data })
      })
      .catch(console.log)
  }

  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/" render={props => (
            <React.Fragment>
              <Home />
            </React.Fragment>
          )} />
          <Route path="/log" render={props => (
            <React.Fragment>
              <Logs logs={this.state.logs} />
            </React.Fragment>
          )} />
          <Route path="/maintenance" render={props => (
            <React.Fragment>
              <h4>Még nincs kész, nézz vissza később. :)</h4>
            </React.Fragment>
          )} />
          <Route path="/cleaning" render={props => (
            <React.Fragment>
              <h4>Még nincs kész, nézz vissza később.</h4>
            </React.Fragment>
          )} />
          <Route path="/login" render={props => (
            <React.Fragment>
              <h4>Még nincs kész, nézz vissza később.</h4>
            </React.Fragment>
          )} />
        </div>
      </Router>
    );
  }

}

export default App;
