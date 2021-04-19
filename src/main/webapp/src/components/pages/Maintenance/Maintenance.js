import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';

class Maintenance extends Component {
    render() {
        return (
            <div /*style={maintenanceStyle}*/ className="component">
                <div className="component-item">
                    <strong>Idő:</strong> {this.props.maintenance.time}<br />
                    <strong>Megjegyzések:</strong> {this.props.maintenance.comment}<br />
                    <strong>Ki?</strong> {this.props.maintenance.user.name}
                </div>
                <div className="delete-button">
                    <button onClick={this.props.deleteMaintenance.bind(this, this.props.maintenance.id)} type="button" className="btn btn-danger">X</button>
                </div>
            </div>
        )
    }
}

//PropTypes
Maintenance.propTypes = {
    maintenance: PropTypes.object.isRequired
}

export default Maintenance;
