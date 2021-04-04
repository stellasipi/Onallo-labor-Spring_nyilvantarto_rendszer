import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './CleaningStyle.css';
import CreateCleaningRoom from './CreateCleaningRoom'

class CreateCleaningNew extends Component {
    render() {
        return (
            <form style={cleaningStyle} /*onSubmit={this.onSubmit}*/>
                <div className="form-group" style={formGroupStyle}>
                    <div>
                        <p style={roomNameStyle}>{this.props.pairings.roomName}</p>
                        <CreateCleaningRoom roomCleaningItems={this.props.pairings.cleaningItems}/>
                    </div>
              </div>
            </form>      
        )
    }
}

const roomNameStyle = {
    fontWeight: 'bold',
    marginBottom: '8px',
    marginTop: '8px'
}

const cleaningStyle = {
    display: 'flex',
    flexDirection: 'column',
    backgroundColor: '#f4f4f4',
    textAlign: 'center',
    margin: '10px 30px',
}

const formGroupStyle = {
    flex: '1',
    margin: '16px 16px',
    alignSelf: 'center',
    width: '80%'
}

CreateCleaningNew.propTypes = {
    createCleaning: PropTypes.func.isRequired,
    pairings: PropTypes.array.isRequired
}

export default CreateCleaningNew;
