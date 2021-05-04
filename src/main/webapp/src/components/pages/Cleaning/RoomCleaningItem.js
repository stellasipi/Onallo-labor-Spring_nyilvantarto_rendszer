import React, { Component } from 'react';
import PropTypes from 'prop-types';
import DoneOutlinedIcon from '@material-ui/icons/DoneOutlined';
import CloseOutlinedIcon from '@material-ui/icons/CloseOutlined';


class RoomCleaningItem extends Component {
    test="teszt Item"
    render() {
        return (
            <div id="room-cleaning-item-cl">
                {this.props.roomCleaningItem.done === true ? <DoneOutlinedIcon/> : <CloseOutlinedIcon/>
                } {this.props.roomCleaningItem.roomCleaningItemPairing.cleaningItemName}
            </div>
        )
    }
}

//PropTypes
RoomCleaningItem.propTypes = {
    roomCleaningItem: PropTypes.object.isRequired
}

export default RoomCleaningItem;
