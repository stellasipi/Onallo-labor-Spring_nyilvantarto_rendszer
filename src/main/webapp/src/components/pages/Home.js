import React, { Component } from 'react';
import './HomeStyle.css'

class Home extends Component {
    render() {
        return (
            <div style={homeStyle}>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/log">Nyitás/zárás</a>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/maintenance">Karbantartás</a>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/cleaning">Takarítás</a>
                <a role="button" className="button btn btn-outline-light" style={buttonStyle} href="/login">Bejelentkezés</a>
            </div>
        )
    }
}

const homeStyle={
    display: 'flex',
    flexDirection: 'column',
    margin: '5% 10%',
}



const buttonStyle={
    fontSize: '30px',
    color: '#44bb44',
    textShadow: '1.5px 1.5px 5px #517351',
    paddingTop: '5%',
    paddingBottom: '5%',
    marginTop: '1%',
    marginBottom: '1%'/*,
    ':active': {
        color: '#f8f9fa'
    }*/
    
}

export default Home
