import React, { Component } from 'react'

class Home extends Component {
    render() {
        return (
            <div style={homeStyle}>
                <a role="button" className="btn btn-light" style={buttonStyle} href="/log">Nyitás/zárás</a>
                <a role="button" className="btn btn-light" style={buttonStyle} href="/maintenance">Karbantartás</a>
                <a role="button" className="btn btn-light" style={buttonStyle} href="/cleaning">Takarítás</a>
            </div>
        )
    }
}

const homeStyle={
    display: 'flex',
    flexDirection: 'column',
}

const buttonStyle={
    fontSize: '20px'
}

export default Home
