import React, { Component } from 'react';
import './HomeStyle.css';
import PropTypes from 'prop-types';
import Button from '@material-ui/core/Button';
import VpnKeyOutlinedIcon from '@material-ui/icons/VpnKeyOutlined';
import SettingsOutlinedIcon from '@material-ui/icons/SettingsOutlined';
import DeleteOutlinedIcon from '@material-ui/icons/DeleteOutlined';
import SupervisorAccountOutlinedIcon from '@material-ui/icons/SupervisorAccountOutlined';

class Home extends Component {

    state = {
        isAdmin: false
    };

    componentDidMount(){
        this.setIsAdmin();
    }

    setIsAdmin = () => {
        if(this.props.roles){
            this.props.roles.map((role)=>{
                if(role.name==="ADMIN"){
                    this.setState({isAdmin: true})
                }
                return "";
            })
        }
    }

    render() {
        return (
            <div className="home-style">
                <Button className="button-style" variant="outlined" type="button" href="/log"> 
                    <VpnKeyOutlinedIcon className="icon-stlye"/>
                    <div className="button-text-home">Nyitás/zárás</div> 
                     
                </Button>
                <Button className="button-style" variant="outlined" type="button" href="/maintenance">
                    <SettingsOutlinedIcon className="icon-stlye"/>
                    <div className="button-text-home">Karbantartás</div> 
                    
                </Button>
                <Button className="button-style" variant="outlined" type="button" href="/cleaning">
                    
                    <DeleteOutlinedIcon className="icon-stlye"/>
                    <div className="button-text-home">Takarítás</div> 
                    
                </Button>
                {this.state.isAdmin ? 
                    <Button className="button-style" variant="outlined" type="button" href="/admin">
                        <SupervisorAccountOutlinedIcon className="icon-stlye"/>
                        <div className="button-text-home">Admin</div> 
                    </Button> : 
                    ""}
            </div>
        )
    }
}

Home.propTypes = {
    roles: PropTypes.array
}

export default Home
