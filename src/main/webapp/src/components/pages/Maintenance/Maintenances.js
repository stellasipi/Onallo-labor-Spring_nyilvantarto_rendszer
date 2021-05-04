import React, { Component } from 'react'
import Maintenance from './Maintenance'
import PropTypes from 'prop-types'

class Maintenances extends Component {
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
        return this.props.maintenances.map((maintenance) => (
            <Maintenance key={maintenance.id} maintenance={maintenance}
                    deleteMaintenance={this.props.deleteMaintenance} isAdmin={this.state.isAdmin} />
        ));
    }
}

//PropTypes
Maintenances.propTypes = {
    maintenances: PropTypes.array.isRequired,
    roles: PropTypes.array.isRequired
}

export default Maintenances;