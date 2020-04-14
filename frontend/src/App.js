import React, {Component} from 'react';
import './App.css';
import Logs from "./components/Logs";
import Header from "./components/layouts/Header";

class App extends Component {

  state = {
    logs: []
  }

  componentDidMount() {
    fetch(/*'http://192.168.0.103:8080/logs/'*/ 'http://localhost:8080/logs/' )
    .then(res => res.json())
    .then((data) => {
      this.setState({ logs: data })
    })
    .catch(console.log)
  }

  render () {
    return (
      <div className="App">
       <Header />
        <Logs logs={this.state.logs} />
      </div>
    );
  }
  
}

export default App;
