import React, {Component} from 'react';
import './App.css';
import Logs from "./Components/Logs"

class App extends Component {

  // that's a comment

  state = {
    logList: []
  }

  componentDidMount() {
    fetch('http://192.168.0.104:8080/logs/')
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
