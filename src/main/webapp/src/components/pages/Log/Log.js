import React, { Component } from 'react'
import PropTypes from 'prop-types';

class Log extends Component {
    render() {
        return (
            <div style={logStyle}>
                <div style={itemStyle}>
                    Típus: {this.props.log.type === 'OPENING' ? 'Nyitás' : 'Zárás'}<br />
                    Idő: {this.props.log.time}<br />
                    {this.props.log.comment != null ? <p style={commentStyle}>Megjegyzések: {this.props.log.comment}</p> : ''}
                    Ki? {this.props.log.user.name}
                </div>
                <div style={deleteButtonStyle}>
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

const logStyle = {
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

const commentStyle = {
    margin: '0px 0px'
}

const deleteButtonStyle = {
    flex: '1',
    margin: '16px 16px',
    fontWeight: 'bold',
    alignSelf: 'center',
    textAlign: 'center'
}

export default Log
