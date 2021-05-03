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
import ArrowRightOutlinedIcon from '@material-ui/icons/ArrowRightOutlined';
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

        pairings: [],
        selectedRoom: '',
        selectedCleaningItem: ''
    };

    ismounted = false;
    didUpdateRunOnce = false;

    componentDidMount(){
        axios.defaults.headers.common['Authorization'] = `Bearer ${this.context.cookies.get('token')}`;
        this.setUsers();
        axios.get(this.context.fetchURL+'user/roles')
        .then(res => {if(this.ismounted) this.setState({ roles: res.data })})
        .catch(error=>{});
        axios.get(this.context.fetchURL+'cleanings/rooms')
        .then(res => {if(this.ismounted) this.setState({ rooms: res.data })})
        .catch(error=>{});
        axios.get(this.context.fetchURL+'cleanings/cleaningItems')
        .then(res => {if(this.ismounted) this.setState({ cleaningItems: res.data })})
        .catch(error=>{});
        this.setPairings();
        this.ismounted=true;
        
    }

    componentWillUnmount(){
        this.ismounted=false;
    }

    componentDidUpdate(){
        if(!this.didUpdateRunOnce && this.ismounted && this.state.roles.length>0){
            this.setRoles();
            this.didUpdateRunOnce=true;
        }
    }

    setPairings(){
        axios.get(this.context.fetchURL+'cleanings/pairings')
        .then(res => {if(this.ismounted) this.setState({ pairings: res.data })})
        .catch(error=>{});
    }

    setRoles(){
        for(var i=0;i<this.state.roles.length;i++){
            this.setState({
                [this.state.roles[i].name]: false
            })
        }
    }

    setUsers(){
        axios.get(this.context.fetchURL+'users')
        .then(res => {if(this.ismounted) this.setState({ users: res.data }) })
        .catch(error=>{});
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
            //reset
            this.setRoles() 
            //load selected user's roles:
            for(var i=0;i<this.state.roles.length;i++){
                for(var j=0;j<e.target.value.roles.length;j++){
                    if(this.state.roles[i].name===e.target.value.roles[j].name){
                        this.setState({
                            [this.state.roles[i].name]: true
                        })
                    }
                    
                }
            }
        }
    }

    onChangeUserRole = (e) =>{
        this.setState({
            [e.target.name]: e.target.checked
        })
    }

    onUpdateUserRole = (e) => {
        e.preventDefault();
        var payload=[];

        for(var i=0;i<this.state.roles.length;i++){
            if(this.state[this.state.roles[i].name]){
                payload.push({name: this.state.roles[i].name})
            }
        }

        axios.put(this.context.fetchURL + 'user/'+this.state.selectedUser.id+'/role?overwriteExisting=true', payload)
        .then(
        res=>this.setUsers(),
        swal({
            title: "A szerepkörök módosultak",
            icon: "success",
            timer: 1500
          })
      )
      .catch(
        err=>{}
      );
      this.setState({
        selectedUser: {},
        selectedUserName:'',
        selectedRolesForUser: [],
      })
      this.setRoles();
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

    onCreateNewPairing = (e) => {
        e.preventDefault();
        axios.post(this.context.fetchURL + 'cleanings/pairing', {
            roomName: this.state.selectedRoom,
            cleaningItemName: this.state.selectedCleaningItem
        })
      .then(
        res=>this.setPairings(),
        swal({
            title: "A párosítás sikeresen létrejött",
            icon: "success",
            timer: 1500
          })
      )
      .catch(
        err=>{swal("Upsz!", err.response.data, "error")}
      );
      this.setPairings();
      this.setState({ selectedRoom: '' , selectedCleaningItem: ''})
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
                                            checked={this.didUpdateRunOnce?this.state[role.name]:false} 
                                            onChange={this.onChangeUserRole}
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
                                            <ListItem button key={room.id}> <ListItemText primary={room.name} /> </ListItem>
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
                                            <ListItem button key={cleaningItem.id}> <ListItemText primary={cleaningItem.name} /> </ListItem>
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
                    <form className="form-admin"onSubmit={this.onCreateNewPairing}>
                        <div className="form-header-admin form-header-admin-word" >Szoba és teendő párosítás létrehozása</div>
                        <div className="pairing-input-admin">
                            {/* list */}
                            <div className="pairing-list-admin">
                                <div className="room-cleaningitem-sub-header">Már létező párosítások:</div>
                                <Paper className="room-cleaningitem-scrollbar-admin">
                                    <List>
                                        {this.state.pairings.map((pairing)=>([
                                            <ListItem button key={pairing.id}> <ListItemText primary={pairing.roomName} /> </ListItem>,
                                            pairing.cleaningItems.map((item)=>(
                                                <ListItem button key={item} style={{marginLeft: '10px'}}> 
                                                    <ArrowRightOutlinedIcon/> 
                                                    <ListItemText primary={item} /> 
                                                </ListItem>
                                            ))
                                        ]))}
                                    </List>
                                </Paper>
                            </div>

                            {/* new room */}
                            <div className="pairing-text-admin">
                                <div className="room-cleaningitem-sub-header">Új:</div>

                                <FormControl className="user-role-input-select-admin">
                                    <InputLabel>Szoba</InputLabel>
                                    <Select name="selectedRoom" value={this.state.selectedRoom} onChange={this.onChange}>
                                        {this.state.rooms.map((room)=>(
                                            <MenuItem key={room.id} value={room.name}> {room.name} </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>

                                <FormControl className="user-role-input-select-admin">
                                    <InputLabel>Teendő</InputLabel>
                                    <Select name="selectedCleaningItem" value={this.state.selectedCleaningItem} onChange={this.onChange}>
                                        {this.state.cleaningItems.map((cleaningItem)=>(
                                            <MenuItem key={cleaningItem.id} value={cleaningItem.name}> {cleaningItem.name} </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>

                                <Button variant="outlined" type="submit">Mentés</Button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        )
    }
}

export default Admin;