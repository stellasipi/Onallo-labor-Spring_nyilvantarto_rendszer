import React, { Component } from 'react'
import Maintenance from './Maintenance'
import PropTypes from 'prop-types'

class Maintenances extends Component {
    render() {
        return this.props.maintenances.map((maintenance) => (
            <Maintenance key={maintenance.id} maintenance={maintenance}
                    deleteMaintenance={this.props.deleteMaintenance} />
        ));
    }
}

//PropTypes
Maintenances.propTypes = {
    maintenances: PropTypes.array.isRequired
}

export default Maintenances;