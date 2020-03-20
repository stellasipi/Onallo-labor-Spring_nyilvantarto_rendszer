import React, {Component} from 'react';
import './App.css';
import Logs from "./Components/Logs"

class App extends Component {
  state = {
    logs: []
  }
  
  componentDidMount(){
    fetch('http://localhost:8080/logs/')
    .then(res => res.json)
    .then(data => {
      this.setState({logs:data})
    })
    .catch(console.log)
  }

  
  render () {
    return (
      // JSX to render goes here...
      /*<Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
            <li>
              <Link to="/users">Users</Link>
            </li>
          </ul>
        </nav>*/

        //{/* A <Switch> looks through its children <Route>s and
            //renders the first one that matches the current URL. */}
        /*<Switch>
          <Route path="/" exact>
            <Page1 />
          </Route>
          <Route path="/users">
            <Page2 />
          </Route>
          <Route path="/about">
            <Page3 />
          </Route>
        </Switch>
      </div>
      </Router>*/

      <Logs logs={this.state.logs} />
    )
  }
}

export default App
