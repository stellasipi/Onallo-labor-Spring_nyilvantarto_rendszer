import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Log extends Component {
    render() {
        return (

            <div style = {logStyle}>
                <p style ={itemStyle}>
                    ID: {this.props.log.id}<br />
                    Type: {this.props.log.type}<br />
                    Time: {this.props.log.time}<br />
                    {this.props.log.comment!=null?<p style={commentStyle}>Comment: {this.props.log.comment}</p>:''}
                    {this.props.log.user.name}
                </p>
                <div style={deleteButtonStyle}>
                    <button onClick={this.props.deleteLog.bind(this,this.props.log.id)} type="button" className="btn btn-danger">X</button>
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
    //justifyContent: 'center'
    textAlign: 'center'
}

export default Log
