import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import './RegisterStyle.css';
import axios from 'axios';
import swal from 'sweetalert';
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';

class Register extends Component {
    static contextTypes = {
        fetchURL: PropTypes.string
    }

    state = {
        name:'',
        username: '',
        password: '',
        scoutGroup: '',
        groupLeader: false,
        scoutGroups: []
    }

    ismounted = false;

    componentDidMount() {
        axios.get(this.context.fetchURL+'scoutGroups')
            .then(res => 
                {if(this.ismounted) this.setState({ scoutGroups: res.data })}
            )
            this.ismounted=true;
    }

    componentWillUnmount(){
        this.ismounted=false;
    }

    onChange = (e) =>{
        this.setState({
            [e.target.name==="scoutGroup"? e.target.name : e.target.id]: e.target.id==="groupLeader"? e.target.checked : e.target.value
        })
    }

    onSubmit = (e) =>{
        e.preventDefault();
        this.createUser();
        this.setState({
            name:'',
            username: '',
            password: '',
            scoutGroup: '',
            groupLeader: false
        })
    }

    createUser = (e) => {
        axios.post(this.context.fetchURL + 'register', {
            name: this.state.name,
            username: this.state.username,
            password: this.state.password,
            scoutGroup: this.state.scoutGroup,
            groupLeader: this.state.groupLeader
        })
      .then(
        res=>{this.props.setRegistration(res.data)},
        swal({
            title: "A felhasználó sikeresen létrejött",
            icon: "success",
            timer: 2000
          })
      )
      .catch(
        err=>{swal("Upsz!", err.response.data, "error")}
      );
    }

    render() {
        if (sessionStorage.getItem("userCreated")==='true') {
            return <Redirect to='/login'/>
        }
        return (
            <form className="register" onSubmit={this.onSubmit}>
                <div className="div-text-group-reg1">
                    <TextField className="div-text-reg" id="name" label="Név" variant="outlined" value={this.state.name} onChange={this.onChange} />
                    <TextField className="div-text-reg" id="username" label="Felhasználónév" variant="outlined" value={this.state.username} onChange={this.onChange} />
                    <TextField className="div-text-reg" id="password" label="Jelszó" type="password" variant="outlined" value={this.state.password} onChange={this.onChange} />

                </div>
                <div className="div-text-group-reg2">
                    <FormControl className="div-form-control div-text-reg">
                        <InputLabel>Őrs</InputLabel>
                        <Select name="scoutGroup" value={this.state.scoutGroup} onChange={this.onChange}>
                            {this.state.scoutGroups.map((scoutGroup)=>(
                                <MenuItem key={scoutGroup} value={scoutGroup}>{scoutGroup}</MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                    <FormControlLabel className="div-text-reg-checkbox" control={
                        <Checkbox id="groupLeader" checked={this.state.groupLeader} onChange={this.onChange} color="default" />
                    } label="Őrsvezető?" />
                    <Button className="div-button-reg" variant="outlined" type="submit">Beküldés</Button>
                </div>
            </form>
        )
    }
}

Register.propTypes = {
    setRegistration: PropTypes.func.isRequired
}

export default Register;