import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Room from './Room'

class Rooms extends Component {
    render() {
        return this.props.rooms.map((room) => (
            <Room key={room.id} room={room} cleaningId={this.props.cleaningId}/>
        ));
    }
}

Rooms.propTypes = {
    rooms: PropTypes.array.isRequired,
    cleaningId: PropTypes.number.isRequired
}

export default Rooms