import React, {Component} from 'react';
import './App.css';
import Logs from "./Components/Logs"

class App extends Component {

  state = {
    logList: []
  }

  componentDidMount() {
    fetch('http://localhost:8080/logs/')
    .then(res => res.json())
    .then((data) => {
      this.setState({ logList: data })
    })
    .catch(console.log)
  }

  render () {
    return (
      <Logs logs={this.state.logList} />
    )
  }
  
}

export default App
