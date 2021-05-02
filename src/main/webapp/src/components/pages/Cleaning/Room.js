import React, { Component } from 'react'
import PropTypes from 'prop-types'
import axios from 'axios';
import RoomCleaningItems from './RoomCleaningItems'

class Room extends Component {
        static contextTypes = {
            fetchURL: PropTypes.string
        }

    state = {
        roomCleaningItems: []
    };

    ismounted = false;
    isRoomExists = true;
    
    componentDidMount() {
        axios.get(this.context.fetchURL+'cleanings/'+ this.props.cleaningId + '/roomCleaning?roomName='+this.props.room.name)
            .then(res => 
                {if(this.ismounted) this.setState({ roomCleaningItems: res.data })}
            )
            .catch(error=>{
                this.isRoomExists=false;
            })
        this.ismounted=true;
    }

    componentWillUnmount(){
        this.ismounted=false;
    }

    render() {
        if(this.isRoomExists){
            return (
                <div style={RoomStyle}>
                    <p style={roomNameStyle}>{this.props.room.name}</p>
                    <RoomCleaningItems roomCleaningItems={this.state.roomCleaningItems}/>
                </div>
            )
        }else{
            return <div></div>
        }
    }
}

Room.propTypes = {
    cleaningId: PropTypes.number.isRequired,
    room: PropTypes.object.isRequired
}

const RoomStyle = {
    border: '1px solid transparent', 
    borderRadius: '5px',
    padding: '8px',
    margin: '10px',
    backgroundColor: '#f4f4f4'
}

const roomNameStyle = {
    fontWeight: 'bold',
    marginBottom: '8px'
}

export default Room