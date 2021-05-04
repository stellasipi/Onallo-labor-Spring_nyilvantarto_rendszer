import React, { Component } from 'react';
import PropTypes from 'prop-types';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';

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
                <FormControlLabel control={
                    <Checkbox  checked={this.state.value} onChange={(e)=>this.onChange(e)} color="default" />
                } label={this.props.roomCleaningItem} />
        )
    }
}

CreateCleaningRoomItem.propTypes = {
    roomCleaningItem: PropTypes.string.isRequired,
    checkedRoomCleaningItem: PropTypes.func.isRequired,
    submitted: PropTypes.bool.isRequired
}

export default CreateCleaningRoomItem;
