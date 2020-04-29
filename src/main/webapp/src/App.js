import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import './App.css';
import Logs from "./components/Log/Logs";
import CreateLog from "./components/Log/CreateLog"
import Header from "./components/layouts/Header";
import Home from "./components/pages/Home";
import axios from 'axios';

class App extends Component {

  fetchURL='http://192.168.0.102:8080/'; //localhost, for mobile testing: 192.168.0.102

  state = {
    logs: []
  }  
  
  componentDidMount(){
    axios.get(this.fetchURL+'logs')
      .then(res=>this.setState({logs: res.data}))
  }

  createLog = (type, comment, userId) => {
    axios.post(this.fetchURL+'logs',{
      type,
      comment,
      user: { 
        id: userId
      }
    })
      .then(
        res => this.setState({ logs: [res.data, ...this.state.logs] })
      );
  }

  deleteLog = (id) => {
    axios.delete(this.fetchURL+`logs/${id}`)
      .then(res => this.setState({logs: [...this.state.logs.filter(log => log.id!==id)]}))
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
              <CreateLog createLog={this.createLog}/>
              <Logs logs={this.state.logs}
              deleteLog={this.deleteLog} />
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
