import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import './LoginStyle.css';
import axios from 'axios';
import swal from 'sweetalert';
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';

class Login extends Component {

    static contextTypes = {
        fetchURL: PropTypes.string
    }

    state = {
        username: '',
        password: ''
    }

    componentDidMount(){
        sessionStorage.setItem('userCreated', false);
        sessionStorage.setItem('registration', false);
    }

    onChange = (e) =>{
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    createToken = () => {
        axios.post(this.context.fetchURL + 'login', {
            username: this.state.username,
            password: this.state.password
        })
      .then(
        res=>{this.props.setAuthenticated(res.data.token)},
        swal({
            title: "Siker",
            icon: "success",
            timer: 1500
          })
      )
      .catch(()=>{
          swal("Upsz!", "A felhasználónév és/vagy a jelszó nem megfelelő.", "error")
      });
    }

    onClick = (e) => {
        e.preventDefault();
        this.createToken();
        this.setState({ username: '', password: '' })
    }

    registrationClick = (e) => {
        sessionStorage.setItem("registration",true);
    }

    render() {
        if (localStorage.getItem("authenticated")) {
            return <Redirect to='/'/>
        }
        return (
            <form className="login" onSubmit={this.onClick}>
                <div className="div-text-group-login">
                    <TextField className="div-text" id="username" label="Felhasználónév" variant="outlined" value={this.state.username} onChange={this.onChange} />
                    <TextField className="div-text" id="password" label="Jelszó" type="password" variant="outlined" value={this.state.password} onChange={this.onChange} />
                </div>
                <div className="div-button-group">
                    <Button className="div-button" variant="outlined" type="submit">Belépés</Button>
                    <Button className="div-button" variant="outlined" href="/register" color="primary" onClick={this.registrationClick}>Regisztráció</Button>
                </div>
            </form>
        )
    }
}

Login.propTypes = {
    setAuthenticated: PropTypes.func.isRequired
}

export default Login;