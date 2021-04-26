import React, { Component } from 'react';
import './HomeStyle.css';
import PropTypes from 'prop-types';

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
            <div style={homeStyle}>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/log">Nyitás/zárás</a>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/maintenance">Karbantartás</a>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/cleaning">Takarítás</a>
                {this.state.isAdmin ? <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/admin">Admin</a> : ""}
            </div>
        )
    }
}

const homeStyle={
    display: 'flex',
    flexDirection: 'column',
    margin: '1% 10%',
}



const buttonStyle={
    fontSize: '30px',
    color: '#44bb44',
    textShadow: '1.5px 1.5px 5px #517351',
    paddingTop: '3%',
    paddingBottom: '3%',
    marginTop: '1%',
    marginBottom: '1%'    
}

Home.propTypes = {
    roles: PropTypes.array
}

export default Home
