import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './CleaningStyle.css';
import CreateCleaningRoom from './CreateCleaningRoom';
import './../../layouts/ComponentSytle.css';

class CreateCleaning extends Component {

    componentDidUpdate(){
        if(this.state.isSubmitted){
            this.setState({
                isSubmitted: false
            })
        }
    }

    state= {
        checkedRoomCleaningItems: [],
        isSubmitted: false
    }

    checkedRoomCleaningItems=(cleaningItems)=>{
        var isExists=false;
        if(this.state.checkedRoomCleaningItems.length!==0){
            for(const [i, value] of this.state.checkedRoomCleaningItems.entries()){
                if(value.id===cleaningItems.id){
                    var array=[...this.state.checkedRoomCleaningItems];
                    array.splice(i,1);
                    this.setState({checkedRoomCleaningItems: [cleaningItems, ...array]});
                    isExists=true;
                }
            }
        };
        if(!isExists){
            this.state.checkedRoomCleaningItems.push(cleaningItems);
        };
    }

    onSubmit = (e) => {
        e.preventDefault();
        var submitableItems=[];
        for(var i = 0; i < this.state.checkedRoomCleaningItems.length; i++){
            for(var j = 0; j < this.state.checkedRoomCleaningItems[i].items.length; j++){        
                var item={
                    done: this.state.checkedRoomCleaningItems[i].items[j].value,
                    roomCleaningItemPairing: {
                        roomName: this.state.checkedRoomCleaningItems[i].id,
                        cleaningItemName: this.state.checkedRoomCleaningItems[i].items[j].name
                    }
                }
                submitableItems.push(item);
                
            }
        };
        this.setState({
            isSubmitted: true
        });
        this.props.createCleaning(submitableItems);
    }

    render() {
        return (
            <form className="component component-create component-create-text" onSubmit={this.onSubmit}>
                <div className="form-group form-group-comp">
                    {this.props.pairings.map((room)=>
                        [
                            <p key="{room}" style={roomNameStyle}>{room.roomName}</p>,
                            <CreateCleaningRoom key={room.id} room={room.roomName} roomCleaningItems={room.cleaningItems} checkedRoomCleaningItems={this.checkedRoomCleaningItems} submitted={this.state.isSubmitted}/>
                        ]
                    )}
              </div>
              <button type="submit" className="btn btn-primary form-group-comp">Hozzáadás</button>
            </form>      
        )
    }
}

const roomNameStyle = {
    fontWeight: 'bold',
    marginBottom: '8px',
    marginTop: '8px'
}

CreateCleaning.propTypes = {
    createCleaning: PropTypes.func.isRequired,
    pairings: PropTypes.array.isRequired
}

export default CreateCleaning;
