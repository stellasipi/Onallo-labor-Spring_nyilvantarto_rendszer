import React, { Component } from 'react'
import './AdminStyle.css';
import axios from 'axios';
import PropTypes from 'prop-types';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import swal from 'sweetalert';

 class Admin extends Component {
    static contextTypes = {
        fetchURL: PropTypes.string,
        cookies: PropTypes.any
    }

    state = {
        users: [],
        selectedUser: {},
        selectedUserName:'',
        selectedRolesForUser: [],
        roles: [],

        rooms: [],
        newRoom: '',

        cleaningItems: [],
        newCleaningItem: '',

        pairings: []
    };

    testText="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    ismounted = false;
    didUpdateRunOnce = false;

    componentDidMount(){
        axios.defaults.headers.common['Authorization'] = `Bearer ${this.context.cookies.get('token')}`;
        axios.get(this.context.fetchURL+'users')
        .then(res => {if(this.ismounted) this.setState({ users: res.data }) })
        .catch(error=>{});
        axios.get(this.context.fetchURL+'user/roles')
        .then(res => {if(this.ismounted) this.setState({ roles: res.data })})
        .catch(error=>{});
        axios.get(this.context.fetchURL+'cleanings/rooms')
        .then(res => {if(this.ismounted) this.setState({ rooms: res.data })})
        .catch(error=>{});
        axios.get(this.context.fetchURL+'cleanings/cleaningItems')
        .then(res => {if(this.ismounted) this.setState({ cleaningItems: res.data })})
        .catch(error=>{});
        this.ismounted=true;
        
    }

    componentWillUnmount(){
        this.ismounted=false;
    }

    componentDidUpdate(){
        if(!this.didUpdateRunOnce && this.ismounted && this.state.roles.length>0){
            this.setRoles();
            // console.log("TESZT:")
            // var testRole={
            //     name: 'ADMIN',
            //     id: 2
            // }
            // console.log(testRole.name);
            // //`Bearer ${cookies.get('token')}`
            // //console.log(this.state.`${testRole.name}`)
            // console.log(this.state[testRole.name])
            this.didUpdateRunOnce=true;
        }
    }

    setRoles(){
        for(var i=0;i<this.state.roles.length;i++){
            this.setState({
                [this.state.roles[i].name]: false
            })
        }
    }

    onChange = (e) =>{
        this.setState({
            [e.target.name]: e.target.value
        })
        if(e.target.name==='selectedUser'){
            this.setState({
                selectedUserName: e.target.value,
                selectedRolesForUser: e.target.value.roles
            })
            //set selected User role for checkbox checkings
        }
    }

    onUpdateUserRole = (e) => {
        e.preventDefault();
        console.log("onUpdateUserRole");
    }

    onCreateNewRoom = (e) => {
        e.preventDefault();
        axios.post(this.context.fetchURL + 'cleanings/room', {
            name: this.state.newRoom
        })
      .then(
        res=>this.setState({ rooms: [...this.state.rooms, res.data] }),
        swal({
            title: "A szoba sikeresen létrejött",
            icon: "success",
            timer: 1500
          })
      )
      .catch(
        err=>{swal("Upsz!", err.response.data, "error")}
      );
      this.setState({ newRoom:'' })
    }

    onCreateNewCleaningItem = (e) => {
        e.preventDefault();
        axios.post(this.context.fetchURL + 'cleanings/cleaningItem', {
            name: this.state.newCleaningItem
        })
      .then(
        res=>this.setState({ cleaningItems: [...this.state.cleaningItems, res.data] }),
        swal({
            title: "A takarítási teendő sikeresen létrejött",
            icon: "success",
            timer: 1500
          })
      )
      .catch(
        err=>{swal("Upsz!", err.response.data, "error")}
      );
      this.setState({ newCleaningItem:'' })
    }

    render() {
        return (
            <div className="admin" onSubmit={this.onSubmit}>
                <div className="form-dividing-div">
                    {/* USER ROLE UPDATE */}
                    <form className="form-admin" onSubmit={this.onUpdateUserRole}>
                        <div className="form-header-admin">Szerepkörök szerekesztése</div>
                
                        <div className="user-role-input-admin">
                            <FormControl className="user-role-input-select-admin">
                                <InputLabel>Felhasználók</InputLabel>
                                <Select name="selectedUser" value={this.state.selectedUserName} onChange={this.onChange}>
                                    {this.state.users.map((user)=>(
                                        <MenuItem key={user.id} value={user}> {user.name} ({user.username}) </MenuItem>
                                    ))}
                                </Select>
                            </FormControl>

                            <div className="user-role-input-check-admin">
                                {this.state.roles.map((role)=>(
                                    <FormControlLabel key={role.id} control={
                                        <Checkbox 
                                            name={role.name} 
                                            // checked={this.ismounted?this.state[role.name]:false} 
                                            // onChange={this.onChange}
                                            disabled={this.state.selectedUserName?false:true} 
                                            color="default" />
                                    } label={role.name} />
                                ))}
                                
                            </div>
                        </div>
                        <Button className="user-role-submit-button-admin" variant="outlined" type="submit">Mentés</Button>
                    </form>

                    {/* ROOM CREATION */}
                    <form className="form-admin" onSubmit={this.onCreateNewRoom}>
                        <div className="form-header-admin">Szoba létrehozása</div>

                        <div className="room-cleaningitem-input-admin">
                            {/* list */}
                            <div className="room-cleaningitem-list-admin">
                                <div className="room-cleaningitem-sub-header">Már létező szobák:</div>
                                <Paper className="room-cleaningitem-scrollbar-admin">
                                    <List>
                                        {this.state.rooms.map((room)=>(
                                            <ListItem key={room.id}> <ListItemText primary={room.name} /> </ListItem>
                                        ))}
                                    </List>
                                </Paper>

                            </div>

                            {/* new room */}
                            <div className="room-cleaningitem-text-admin">
                                <div className="room-cleaningitem-sub-header">Új:</div>
                                <TextField name="newRoom" label="Új szoba neve" variant="outlined" value={this.state.newRoom} onChange={this.onChange} />
                                <Button variant="outlined" type="submit">Mentés</Button>
                            </div>
                        </div>
                        
                    </form>
                </div>

                <div className="form-dividing-div">
                
                    {/* CLEANING ITEM CREATION */}
                    <form className="form-admin" onSubmit={this.onCreateNewCleaningItem}>
                        <div className="form-header-admin">Takarítási teendő létrehozása</div>

                        <div className="room-cleaningitem-input-admin">
                            {/* list */}
                            <div className="room-cleaningitem-list-admin">
                                <div className="room-cleaningitem-sub-header">Már létező teendők:</div>
                                <Paper className="room-cleaningitem-scrollbar-admin">
                                    <List>
                                        {this.state.cleaningItems.map((cleaningItem)=>(
                                            <ListItem key={cleaningItem.id}> <ListItemText primary={cleaningItem.name} /> </ListItem>
                                        ))}
                                    </List>
                                </Paper>
                            </div>

                            {/* new room */}
                            <div className="room-cleaningitem-text-admin">
                                <div className="room-cleaningitem-sub-header">Új:</div>
                                <TextField name="newCleaningItem" label="Új teendő neve" variant="outlined" value={this.state.newCleaningItem} onChange={this.onChange} />
                                <Button variant="outlined" type="submit">Mentés</Button>
                            </div>
                        </div>
                        
                    </form>

                    {/* PAIRING */}
                    <form className="form-admin">
                        <div className="form-header-admin">Szoba és teendő párosítás létrehozása</div>
                        {this.testText}
                    </form>
                </div>
            </div>
        )
    }
}

export default Admin;