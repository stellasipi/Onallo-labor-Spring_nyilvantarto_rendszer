import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Log extends Component {
    render() {
        return (
            <div style = {itemStyle}>
                <p style = {testStyle}>ID: {this.props.log.id}</p>
                <p style = {testStyle}>Type: {this.props.log.type}</p>
                <p style = {testStyle}>Time: {this.props.log.time}</p>
                <p style = {testStyle}>Comment: {this.props.log.comment}</p>
                <p style = {testStyle}>{this.props.log.user.name}</p>
            </div>
        )
    }
}

//PropTypes
Log.propTypes = {
    log: PropTypes.object.isRequired
}

const itemStyle = {
    backgroundColor: '#f4f4f4',
    textAlign: 'left',
    margin: '10px 30px'
}

const testStyle = {
    margin: '0px'
}

export default Log
