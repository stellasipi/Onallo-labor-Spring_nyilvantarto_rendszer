import React, { Component } from 'react';
import PropTypes from 'prop-types';
import RoomCleaningItem from './RoomCleaningItem';

class RoomCleaningItems extends Component {

    render() {
        return this.props.roomCleaningItems.map((roomCleaningItem) => (
            <RoomCleaningItem key={roomCleaningItem.id} roomCleaningItem={roomCleaningItem}/>
        ));
    }
}

//PropTypes
RoomCleaningItems.propTypes = {
    roomCleaningItems: PropTypes.array.isRequired
}

export default RoomCleaningItems;