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
import CreateCleanings from './components/pages/Cleaning/CreateCleaning';
import PageHeader from './components/pages/PageHeader'

const fetchURL = 'http://localhost:8080/'; //localhost, for mobile testing: 192.168.0.102

class App extends Component {
  static childContextTypes = {
    fetchURL: PropTypes.string
  }

  getChildContext() {
    return { fetchURL }
  }

  state = {
    logs: [],
    maintenances: [],
    rooms: [],
    cleanings: []
  }

  //GET requests
  componentDidMount() {
    axios.get(fetchURL + 'logs')
      .then(res => this.setState({ logs: res.data }));
    axios.get(fetchURL + 'maintenances')
      .then(res => this.setState({ maintenances: res.data }));
    axios.get(fetchURL + 'cleanings/rooms')
      .then(res => this.setState({ rooms: res.data }));
    axios.get(fetchURL + 'cleanings')
      .then(res => this.setState({ cleanings: res.data }));
  }

  //POST requests
  createLog = (type, comment, userId) => {
    axios.post(fetchURL + 'logs', {
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
    axios.post(fetchURL + 'maintenances', {
      comment: comment!==''?comment:null,
      user: {
        id: userId
      }
    })
      .then(
        res => this.setState({ maintenances: [res.data, ...this.state.maintenances] })
      );
  }

  createCleaning = (
    pince_rekeszek_name, pince_rekeszek_done,
    pince_felmosas_name, pince_felmosas_done,

    nagyTerem_lomok_name, nagyTerem_lomok_done,
    nagyTerem_elrendezes_name, nagyTerem_elrendezes_done,
    nagyTerem_felmosas_name, nagyTerem_felmosas_done,

    konyha_konyhapult_name, konyha_konyhapult_done,
    konyha_konyhabutor_name, konyha_konyhabutor_done,
    konyha_mosogatas_name, konyha_mosogatas_done,
    konyha_felmosas_name, konyha_felmosas_done,

    kozepsoTerem_elrendezes_name, kozepsoTerem_elrendezes_done,
    kozepsoTerem_faliujsag_name, kozepsoTerem_faliujsag_done,
    kozepsoTerem_vitrin_name, kozepsoTerem_vitrin_done,
    kozepsoTerem_raktar_name, kozepsoTerem_raktar_done,
    kozepsoTerem_felmosas_name, kozepsoTerem_felmosas_done,

    mosdok_tisztaKagylok_name, mosdok_tisztaKagylok_done,
    mosdok_wcpapir_name, mosdok_wcpapir_done,
    mosdok_torulkozo_name, mosdok_torulkozo_done,
    mosdok_felmosas_name, mosdok_felmosas_done) => {
    axios.post(fetchURL + 'cleanings', [
      { room: { name: "Pince" }, cleaningItem: { name: pince_rekeszek_name }, done: pince_rekeszek_done !== '' ? pince_rekeszek_done : false },
      { room: { name: "Pince" }, cleaningItem: { name: pince_felmosas_name }, done: pince_felmosas_done !== '' ? pince_felmosas_done : false },

      { room: { name: "Nagy terem" }, cleaningItem: { name: nagyTerem_lomok_name }, done: nagyTerem_lomok_done !== '' ? nagyTerem_lomok_done : false },
      { room: { name: "Nagy terem" }, cleaningItem: { name: nagyTerem_elrendezes_name }, done: nagyTerem_elrendezes_done !== '' ? nagyTerem_elrendezes_done : false },
      { room: { name: "Nagy terem" }, cleaningItem: { name: nagyTerem_felmosas_name }, done: nagyTerem_felmosas_done !== '' ? nagyTerem_felmosas_done : false },

      { room: { name: "Konyha" }, cleaningItem: { name: konyha_konyhapult_name }, done: konyha_konyhapult_done !== '' ? konyha_konyhapult_done : false },
      { room: { name: "Konyha" }, cleaningItem: { name: konyha_konyhabutor_name }, done: konyha_konyhabutor_done !== '' ? konyha_konyhabutor_done : false },
      { room: { name: "Konyha" }, cleaningItem: { name: konyha_mosogatas_name }, done: konyha_mosogatas_done !== '' ? konyha_mosogatas_done : false },
      { room: { name: "Konyha" }, cleaningItem: { name: konyha_felmosas_name }, done: konyha_felmosas_done !== '' ? konyha_felmosas_done : false },

      { room: { name: "Középső terem" }, cleaningItem: { name: kozepsoTerem_elrendezes_name }, done: kozepsoTerem_elrendezes_done !== '' ? kozepsoTerem_elrendezes_done : false },
      { room: { name: "Középső terem" }, cleaningItem: { name: kozepsoTerem_faliujsag_name }, done: kozepsoTerem_faliujsag_done !== '' ? kozepsoTerem_faliujsag_done : false },
      { room: { name: "Középső terem" }, cleaningItem: { name: kozepsoTerem_vitrin_name }, done: kozepsoTerem_vitrin_done !== '' ? kozepsoTerem_vitrin_done : false },
      { room: { name: "Középső terem" }, cleaningItem: { name: kozepsoTerem_raktar_name }, done: kozepsoTerem_raktar_done !== '' ? kozepsoTerem_raktar_done : false },
      { room: { name: "Középső terem" }, cleaningItem: { name: kozepsoTerem_felmosas_name }, done: kozepsoTerem_felmosas_done !== '' ? kozepsoTerem_felmosas_done : false },

      { room: { name: "Mosdók" }, cleaningItem: { name: mosdok_tisztaKagylok_name }, done: mosdok_tisztaKagylok_done !== '' ? mosdok_tisztaKagylok_done : false },
      { room: { name: "Mosdók" }, cleaningItem: { name: mosdok_wcpapir_name }, done: mosdok_wcpapir_done !== '' ? mosdok_wcpapir_done : false },
      { room: { name: "Mosdók" }, cleaningItem: { name: mosdok_torulkozo_name }, done: mosdok_torulkozo_done !== '' ? mosdok_torulkozo_done : false },
      { room: { name: "Mosdók" }, cleaningItem: { name: mosdok_felmosas_name }, done: mosdok_felmosas_done !== '' ? mosdok_felmosas_done : false },
    ])
      .then(
        res => this.setState({ cleanings: [res.data, ...this.state.cleanings] })
      )
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
              <PageHeader title="Nyitás/Zárás"/>
              <CreateLog createLog={this.createLog} />
              <Logs logs={this.state.logs}
                deleteLog={this.deleteLog} />
            </React.Fragment>
          )} />
          <Route path="/maintenance" render={props => (
            <React.Fragment>
              <PageHeader title="Karbantartás"/>
              <CreateMaintenance createMaintenance={this.createMaintenance} />
              <Maintenances maintenances={this.state.maintenances}
                deleteMaintenance={this.deleteMaintenance} />
            </React.Fragment>
          )} />
          <Route path="/cleaning" render={props => (
            <React.Fragment>
              <PageHeader title="Takarítás"/>
              <CreateCleanings createCleaning={this.createCleaning} />
              <Cleanings cleanings={this.state.cleanings}
                rooms={this.state.rooms}
                deleteCleaning={this.deleteCleaning} />
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
