import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';

class Log extends Component {
    render() {
        return (
            <div className="component">
                <div className="component-item">
                    <strong>Típus:</strong> {this.props.log.type === 'OPENING' ? 'Nyitás' : 'Zárás'}<br />
                    <strong>Idő:</strong> {this.props.log.time}<br />
                    {this.props.log.comment != null ? <p style={commentStyle}><strong>Megjegyzések:</strong> {this.props.log.comment}</p> : ''}
                    <strong>Ki?</strong> {this.props.log.user.name}
                </div>
                <div className="delete-button">
                    <button onClick={this.props.deleteLog.bind(this, this.props.log.id)} type="button" className="btn btn-danger">X</button>
                </div>
            </div>

        )
    }
}

//PropTypes
Log.propTypes = {
    log: PropTypes.object.isRequired
}

const commentStyle = {
    margin: '0px 0px'
}

export default Log
