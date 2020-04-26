import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Log extends Component {
    render() {
        const comment=this.props.log.comment;
        return (
            <div style = {itemStyle}>
                <p>
                    ID: {this.props.log.id}<br />
                    Type: {this.props.log.type}<br />
                    Time: {this.props.log.time}<br />
                    {comment!=null?'Comment: '+comment+'\r\n':''}
                    {this.props.log.user.name}
                </p>
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

export default Log
