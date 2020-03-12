import React from 'react';
import './App.css';
import Page1 from "./Pages/Page1";
import Page2 from "./Pages/Page2";
import Page3 from "./Pages/Page3";

/* Utils */
import {
  BrowserRouter as Router, Switch,
  Route,
  Link
} from "react-router-dom"

function App() {
  return (
    <Router>
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
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
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
    </Router>)
}

export default App;
