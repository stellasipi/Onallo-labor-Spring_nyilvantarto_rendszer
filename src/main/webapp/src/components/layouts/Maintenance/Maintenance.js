import React, { Component } from 'react'
import PropTypes from 'prop-types';

class Maintenance extends Component {
    render() {
        return (
            <div style={maintenanceStyle}>
                <p style={itemStyle}>
                    Idő: {this.props.maintenance.time}<br />
                    Megjegyzések: {this.props.maintenance.comment}<br />
                    Ki? {this.props.maintenance.user.name}
                </p>
                <div style={deleteButtonStyle}>
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

const maintenanceStyle = {
    display: 'flex',
    flexDirection: 'row',
    backgroundColor: '#f4f4f4',
    textAlign: 'left',
    margin: '10px 30px'
}

const itemStyle = {
    flex: '6',
    margin: '16px 16px'
}

const deleteButtonStyle = {
    flex: '1',
    margin: '16px 16px',
    fontWeight: 'bold',
    alignSelf: 'center',
    textAlign: 'center'
}

export default Maintenance;
