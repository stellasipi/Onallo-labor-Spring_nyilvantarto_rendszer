import React, { Component } from 'react'
import PropTypes from 'prop-types'
import axios from 'axios';
import RoomCleaningItems from './RoomCleaningItems'

class Room extends Component {
    static contextTypes = {
        fetchURL: PropTypes.string
    }

    state = {
        roomCleaningItems: []
    };

    componentDidMount() {
        axios.get(this.context.fetchURL+'cleanings/'+ this.props.cleaningId + '/roomCleaning/'+this.props.room.name)
            .then(res => this.setState({ roomCleaningItems: res.data }))
    }
    render() {
        return (
            <div style={RoomStyle}>
                {this.props.room.name}
                <RoomCleaningItems roomCleaningItems={this.state.roomCleaningItems}/>
            </div>
        )
    }
}

Room.propTypes = {
    cleaningId: PropTypes.number.isRequired,
    room: PropTypes.object.isRequired
}

const RoomStyle = {
    border: '1px solid black', 
    borderRadius: '5px',
    padding: '8px',
    margin: '10px',
    fontWeight: 'bold'
}

export default Room