import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';
import Button from '@material-ui/core/Button';
import HighlightOffOutlinedIcon from '@material-ui/icons/HighlightOffOutlined';

class Maintenance extends Component {
    render() {
        return (
            <div className="component">
                <div className="component-item">
                    <strong>Idő:</strong> {this.props.maintenance.time}<br />
                    <strong>Megjegyzések:</strong> {this.props.maintenance.comment}<br />
                    <strong>Ki?</strong> {this.props.maintenance.user.name}
                </div>
                {this.props.isAdmin ? 
                <Button id="delete-button" className="delete-button" onClick={this.props.deleteMaintenance.bind(this, this.props.maintenance.id)} variant="outlined" type="button">
                        <HighlightOffOutlinedIcon/>
                </Button>
                : "" }
            </div>
        )
    }
}

//PropTypes
Maintenance.propTypes = {
    maintenance: PropTypes.object.isRequired,
    deleteMaintenance: PropTypes.func.isRequired,
    isAdmin: PropTypes.bool.isRequired
}

export default Maintenance;
