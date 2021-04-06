import React, { Component } from 'react';
import PropTypes from 'prop-types';
import CreateCleaningRoomItem from './CreateCleaningRoomItem'

class CreateCleaningRoom extends Component {

    componentDidMount(){
        this.pushUpItems();
    }

    state={
        items: []
    }

    checkedRoomCleaningItem=(cleaningItem)=>{
        var isExists=false;
        if(this.state.items.length!==0){
            for(const [i, value] of this.state.items.entries()){
                if(value.name===cleaningItem.name){
                    var array=[...this.state.items];
                    array.splice(i,1);
                    this.setState({items: [cleaningItem, ...array]}, this.pushUpItems);
                    isExists=true;
                }
            }
        };
        if(!isExists){
            this.state.items.push(cleaningItem);
            this.pushUpItems();
        };
               
    }

    pushUpItems = () => {
        this.props.checkedRoomCleaningItems({id: this.props.room, items: this.state.items});
    }

    render() {
        return (
            this.props.roomCleaningItems.map((cleaningItem)=>
                <CreateCleaningRoomItem key={cleaningItem} roomCleaningItem={cleaningItem} checkedRoomCleaningItem={this.checkedRoomCleaningItem} submitted={this.props.submitted}/>
            )
        )
    }
}

CreateCleaningRoom.propTypes = {
    room: PropTypes.string.isRequired,
    roomCleaningItems: PropTypes.array.isRequired,
    checkedRoomCleaningItems: PropTypes.func.isRequired,
    submitted: PropTypes.bool.isRequired
}

export default CreateCleaningRoom;