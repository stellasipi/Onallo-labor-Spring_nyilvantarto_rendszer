import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { ListGroupItem } from 'reactstrap';
import './CleaningStyle.css';
import Rooms from './Rooms';
import './../../layouts/ComponentSytle.css';
import Button from '@material-ui/core/Button';
import HighlightOffOutlinedIcon from '@material-ui/icons/HighlightOffOutlined';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Collapse from '@material-ui/core/Collapse';
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';


class Cleaning extends Component {
    state = {
        collapse: null
    };
    
    toggle() {
        this.setState({ collapse: !this.state.collapse });
    }

    render() {
        return (
            <ListGroupItem  className="collapse-item-cl">

                {/* fejléc rész */}
                <ListItem button onClick={() => {
                    this.toggle();
                }}>
                    <div className="component-item">
                        <p style={dateStyle}>{this.props.cleaning.time}</p> {this.props.cleaning.scoutGroup.name} őrs
                        <p style={creatorStyle}>{this.props.cleaning.user.name}</p>
                    </div>
                    {this.props.isAdmin ? 
                    <Button id="delete-button" className="delete-button" onClick={this.props.deleteCleaning.bind(this, this.props.cleaning.id)} variant="outlined" type="button">
                        <HighlightOffOutlinedIcon/>
                    </Button>
                    : ""}
                    {this.state.collapse ? <ExpandLess /> : <ExpandMore />}
                </ListItem>

                {/* legördülő rész */}
                <Collapse in={this.state.collapse} timeout="auto" unmountOnExit>
                    <List id="collapse-list-cl" component="div" disablePadding>
                    <ListItem >
                        <div className="collapse-open-rooms-cl">
                            <Rooms rooms={this.props.rooms} cleaningId={this.props.cleaning.id} />
                        </div>
                    </ListItem>
                    </List>
                </Collapse>

            </ListGroupItem>
        )
    }
}

//PropTypes
Cleaning.propTypes = {
    cleaning: PropTypes.object.isRequired,
    rooms: PropTypes.array.isRequired,
    isAdmin: PropTypes.bool.isRequired
}

const dateStyle = {
    fontSize: '18px',
    fontWeight: 'bold',
    margin: '0px'
}

const creatorStyle = {
    fontStyle: 'italic',
    margin: '0px',
    fontSize: '12px'
}

export default Cleaning;
