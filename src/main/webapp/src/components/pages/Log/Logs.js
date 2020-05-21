import React, { Component } from 'react';
import Log from './Log';
import PropTypes from 'prop-types';

class Logs extends Component {
    render() {
        return this.props.logs.map((log) => (
            <Log key={log.id} log={log}
                deleteLog={this.props.deleteLog} />
        ));
    }
}

//PropTypes
Logs.propTypes = {
    logs: PropTypes.array.isRequired
}

export default Logs;