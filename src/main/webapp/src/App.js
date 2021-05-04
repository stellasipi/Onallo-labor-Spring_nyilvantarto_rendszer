import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import axios from 'axios';
import Cookies from 'universal-cookie';
import './App.css';
import Logs from "./components/pages/Log/Logs";
import CreateLog from "./components/pages/Log/CreateLog";
import Header from "./components/layouts/Header";
import Home from "./components/pages/Home/Home";
import Maintenances from './components/pages/Maintenance/Maintenances';
import CreateMaintenance from './components/pages/Maintenance/CreateMaintenance';
import Cleanings from './components/pages/Cleaning/Cleanings';
import PageHeader from './components/pages/PageHeader';
import Login from './components/pages/Login/Login';
import Register from './components/pages/Register/Register';
import CreateCleaning from './components/pages/Cleaning/CreateCleaning';
import Admin from './components/pages/Admin/Admin'
import PrivateRoute from './components/PrivateRoute';

//const fetchURL = 'http://localhost:8080/';
const fetchURL = 'http://192.168.31.235:8080/'; //for mobile testing
const cookies = new Cookies();

class App extends Component {
  
  static childContextTypes = {
    fetchURL: PropTypes.string,
    cookies: PropTypes.any
  }

  getChildContext() {
    return { fetchURL, cookies }
  }

  state = {
    logs: [],
    maintenances: [],
    rooms: [],
    cleanings: [],
    pairings: [],
    currentUser: '',
    authenticated: false,
    registration: false
  }

  //GET requests
  componentDidMount(){
    if(localStorage.getItem("authenticated")==='true'){
      this.getRequests();
    }
  }

  componentDidUpdate(){
    if(localStorage.getItem("authenticated")==='true' && localStorage.getItem("updated")==='false'){
      this.getRequests();
      localStorage.setItem('updated',true);
    }
  }

  getRequests = () =>{
    this.setState({authenticated: true})
    axios.defaults.headers.common['Authorization'] = `Bearer ${cookies.get('token')}`;
    axios.get(fetchURL + 'logs')
      .then(res => this.setState({ logs: res.data }));
    axios.get(fetchURL + 'maintenances')
      .then(res => this.setState({ maintenances: res.data }));
    axios.get(fetchURL + 'cleanings/rooms')
      .then(res => this.setState({ rooms: res.data }));
    axios.get(fetchURL + 'cleanings')
      .then(res => this.setState({ cleanings: res.data }));
    axios.get(fetchURL + 'cleanings/pairings')
      .then(res => this.setState({ pairings: res.data }));
    axios.get(fetchURL + 'user')
      .then(res => this.setState({ currentUser: res.data }));
  }

  setAuthenticated = (token) => {
    cookies.set("token",token)
    localStorage.setItem('authenticated', true);
    localStorage.setItem('updated',false);
    this.setState({authenticated: true})
  }

  logout = () => {
    cookies.remove("token")
    localStorage.removeItem('authenticated');
    localStorage.removeItem('updated');
    this.setState({authenticated:false});
    axios.get(fetchURL + 'logout');
  }

  setRegistration = (object) =>{
    sessionStorage.setItem('userCreated', true);
    sessionStorage.setItem('registration', false);
    this.setState({registration:true});
    this.setState({registration:false});
  }

  //POST requests
  createLog = (type, comment) => {
    axios.post(fetchURL + 'logs', {
      type,
      comment: comment!==''?comment:null
    })
      .then(
        res => this.setState({ logs: [res.data, ...this.state.logs] })
      )
      .catch(error=>{});
  }

  createMaintenance = (comment, userId) => {
    axios.post(fetchURL + 'maintenances', {
      comment: comment!==''?comment:null,
      user: {
        id: userId
      }
    })
      .then(
        res => this.setState({ maintenances: [res.data, ...this.state.maintenances] })
      )
      .catch(error=>{});
  }

  createCleaning = (roomCleaningItems) => {
    const values=JSON.parse(JSON.stringify(roomCleaningItems));
    axios.post(fetchURL + 'cleanings', values)
    .then(
      res => this.setState({ cleanings: [res.data, ...this.state.cleanings] })
    )
    .catch(error=>{});
  }

  //DELETE requests
  deleteLog = (id) => {
    axios.delete(fetchURL + `logs/${id}`)
      .then(res => this.setState({ logs: [...this.state.logs.filter(log => log.id !== id)] }))
  }

  deleteMaintenance = (id) => {
    axios.delete(fetchURL + `maintenances/${id}`)
      .then(res => this.setState({ maintenances: [...this.state.maintenances.filter(maintenance => maintenance.id !== id)] }))
  }

  deleteCleaning = (id) => {
    axios.delete(fetchURL + `cleanings/${id}`)
      .then(res => this.setState({ cleanings: [...this.state.cleanings.filter(cleanings => cleanings.id !== id)] }))
  }


  render() {
    return (
      <BrowserRouter>
      <div className="App">
        <Header logout={this.logout}/>
        <Switch>
          <PrivateRoute path="/" exact component={() => 
                        <React.Fragment>
                          <Home roles={this.state.currentUser.roles} />
                        </React.Fragment>} />
          <PrivateRoute path="/log" exact component={() => 
                        <React.Fragment>
                          <PageHeader title="Nyitás/Zárás"/> 
                          <CreateLog createLog={this.createLog} /> 
                          <Logs logs={this.state.logs} deleteLog={this.deleteLog} />
                        </React.Fragment>} />
          <PrivateRoute path="/maintenance" exact component={() => 
                        <React.Fragment>
                          <PageHeader title="Karbantartás"/>
                          <CreateMaintenance createMaintenance={this.createMaintenance} />
                          <Maintenances maintenances={this.state.maintenances} deleteMaintenance={this.deleteMaintenance} />
                        </React.Fragment>} />
          <PrivateRoute path="/cleaning" exact component={() => 
                        <React.Fragment>
                          <PageHeader title="Takarítás"/>
                          <CreateCleaning createCleaning={this.createCleaning} pairings={this.state.pairings} />
                          <Cleanings cleanings={this.state.cleanings} rooms={this.state.rooms} deleteCleaning={this.deleteCleaning} />
                        </React.Fragment>} />
          <PrivateRoute path="/admin" requiredRole="ADMIN" roles={this.state.currentUser.roles} exact component={() => 
                        <React.Fragment>
                          <PageHeader title="Admin felület"/>
                          <Admin />
                        </React.Fragment>} />
          <Route path="/login" exact component={() => 
                <React.Fragment>
                  <PageHeader title="Bejelentkezés"/>
                  <Login setAuthenticated={this.setAuthenticated}/>
                </React.Fragment>}/>
          <Route path="/register" exact component={() => 
                <React.Fragment>
                  <PageHeader title="Regisztráció"/>
                  <Register setRegistration={this.setRegistration}/>
                </React.Fragment>}/>
          <Route exact component={() => 
                <React.Fragment>
                  <PageHeader title="Nem található"/>
                </React.Fragment>}/>
        </Switch>
       </div> 
      </BrowserRouter>
    );
  }

}

export default App;
