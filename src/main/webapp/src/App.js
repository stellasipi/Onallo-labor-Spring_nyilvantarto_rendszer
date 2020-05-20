import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import './App.css';
import Logs from "./components/pages/Log/Logs";
import CreateLog from "./components/pages/Log/CreateLog";
import Header from "./components/layouts/Header";
import Home from "./components/pages/Home/Home";
import axios from 'axios';
import Maintenances from './components/pages/Maintenance/Maintenances';
import CreateMaintenance from './components/pages/Maintenance/CreateMaintenance';
import Cleanings from './components/pages/Cleaning/Cleanings';

const fetchURL='http://192.168.0.102:8080/'; //localhost, for mobile testing: 192.168.0.102

class App extends Component {
  static childContextTypes = {
    fetchURL: PropTypes.string
  }

  getChildContext(){
    return{fetchURL}
  }

  state = {
    logs: [],
    maintenances: [],
    rooms: [],
    cleanings: []
  }  

  //GET requests
  componentDidMount(){
    axios.get(fetchURL+'logs')
      .then(res=>this.setState({logs: res.data}));
    axios.get(fetchURL+'maintenances')
      .then(res=>this.setState({maintenances: res.data}));
    axios.get(fetchURL+'cleanings/rooms')
      .then(res=>this.setState({rooms: res.data}));
    axios.get(fetchURL+'cleanings')
      .then(res=>this.setState({cleanings: res.data}));
    
  }

  //POST requests
  createLog = (type, comment, userId) => {
    axios.post(fetchURL+'logs',{
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
  
  createMaintenance = (comment, userId) => {
    axios.post(fetchURL+'maintenances',{
      comment,
      user: { 
        id: userId
      }
    })
      .then(
        res => this.setState({ maintenances: [res.data, ...this.state.maintenances] })
      );
  }

  //DELETE requests
  deleteLog = (id) => {
    axios.delete(fetchURL+`logs/${id}`)
      .then(res => this.setState({logs: [...this.state.logs.filter(log => log.id!==id)]}))
  }

  deleteMaintenance = (id) => {
    axios.delete(fetchURL+`maintenances/${id}`)
      .then(res => this.setState({maintenances: [...this.state.maintenances.filter(maintenance => maintenance.id!==id)]}))
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
              <CreateMaintenance createMaintenance={this.createMaintenance} />
              <Maintenances maintenances={this.state.maintenances} 
              deleteMaintenance={this.deleteMaintenance}/>
            </React.Fragment>
          )} />
          <Route path="/cleaning" render={props => (
            <React.Fragment>
              <Cleanings cleanings={this.state.cleanings} 
              rooms={this.state.rooms} />
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
