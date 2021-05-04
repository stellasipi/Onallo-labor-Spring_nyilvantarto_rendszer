import React, { Component } from 'react';
import Log from './Log';
import PropTypes from 'prop-types';

class Logs extends Component {
    state = {
        isAdmin: false
    };

    componentDidMount(){
        this.setIsAdmin();
    }

    setIsAdmin = () => {
        if(this.props.roles){
            this.props.roles.map((role)=>{
                if(role.name==="ADMIN"){
                    this.setState({isAdmin: true})
                }
                return "";
            })
        }
    }
    render() {
        return this.props.logs.map((log) => (
            <Log key={log.id} log={log}
                deleteLog={this.props.deleteLog} isAdmin={this.state.isAdmin} />
        ));
    }
}

//PropTypes
Logs.propTypes = {
    logs: PropTypes.array.isRequired,
    roles: PropTypes.array.isRequired
}

export default Logs;