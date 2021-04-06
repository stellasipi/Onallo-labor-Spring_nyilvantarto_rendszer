import React, { Component } from 'react';
import PropTypes from 'prop-types';

class CreateCleaningRoomItem extends Component {

    componentDidMount(){
        this.pushUpItem();
    }

    componentDidUpdate(prevProps){
        if(prevProps.submitted!==this.props.submitted && this.props.submitted){
            this.setState({value: false})
        }
    }

    state = {
        value: false
    }

    onChange = (e) => {
        this.setState({
            value: e.target.checked
        },this.pushUpItem);
    }

    pushUpItem = () => {
        this.props.checkedRoomCleaningItem({name: this.props.roomCleaningItem, value: this.state.value});
    }

    render() {
        return (
            <div className="form-check"  >
                <input type="checkbox" className="form-check-input" checked={this.state.value} onChange={(e)=>this.onChange(e)}/>
                <label className="form-check-label">{this.props.roomCleaningItem}</label>
            </div>
        )
    }
}

CreateCleaningRoomItem.propTypes = {
    roomCleaningItem: PropTypes.string.isRequired,
    checkedRoomCleaningItem: PropTypes.func.isRequired,
    submitted: PropTypes.bool.isRequired
}

export default CreateCleaningRoomItem;
