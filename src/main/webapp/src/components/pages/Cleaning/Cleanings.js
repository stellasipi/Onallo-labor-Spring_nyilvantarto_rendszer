import React, { Component } from 'react'
import Cleaning from './Cleaning'
import PropTypes from 'prop-types'

class Cleanings extends Component {
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
        return this.props.cleanings.map((cleaning) => (
            <Cleaning key={cleaning.id} cleaning={cleaning} 
            rooms={this.props.rooms} deleteCleaning={this.props.deleteCleaning} isAdmin={this.state.isAdmin}/>
        ));
    }
}

//PropTypes
Cleanings.propTypes = {
    cleanings: PropTypes.array.isRequired,
    deleteCleaning: PropTypes.func.isRequired,
    rooms: PropTypes.array.isRequired,
    roles: PropTypes.array
}

export default Cleanings;