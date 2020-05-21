import React, { Component } from 'react'
import Cleaning from './Cleaning'
import PropTypes from 'prop-types'

class Cleanings extends Component {
    render() {
        return this.props.cleanings.map((cleaning) => (
            <Cleaning key={cleaning.id} cleaning={cleaning} 
            rooms={this.props.rooms} deleteCleaning={this.props.deleteCleaning}/>
        ));
    }
}

//PropTypes
Cleanings.propTypes = {
    cleanings: PropTypes.array.isRequired,
    rooms: PropTypes.array.isRequired
}

export default Cleanings;