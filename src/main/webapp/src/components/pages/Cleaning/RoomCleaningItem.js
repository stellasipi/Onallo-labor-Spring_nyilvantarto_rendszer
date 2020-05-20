import React, { Component } from 'react';
import PropTypes from 'prop-types';


class RoomCleaningItem extends Component {
    render() {
        return (
            <div style={ItemStyle}>
                {this.props.roomCleaningItem.done === true ?
                    <svg class="bi bi-check" width="16" height="16" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M13.854 3.646a.5.5 0 010 .708l-7 7a.5.5 0 01-.708 0l-3.5-3.5a.5.5 0 11.708-.708L6.5 10.293l6.646-6.647a.5.5 0 01.708 0z" clip-rule="evenodd" />
                    </svg>
                    :
                    <svg class="bi bi-x" width="16" height="16" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 010 .708l-7 7a.5.5 0 01-.708-.708l7-7a.5.5 0 01.708 0z" clip-rule="evenodd" />
                        <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 000 .708l7 7a.5.5 0 00.708-.708l-7-7a.5.5 0 00-.708 0z" clip-rule="evenodd" />
                    </svg>
                } {this.props.roomCleaningItem.cleaningItem.name}
            </div>
        )
    }
}

//PropTypes
RoomCleaningItem.propTypes = {
    roomCleaningItem: PropTypes.object.isRequired
}

const ItemStyle = {
    fontWeight: 'normal'
}

export default RoomCleaningItem;
