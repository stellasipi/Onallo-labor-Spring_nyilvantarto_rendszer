import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { ListGroupItem, Collapse } from 'reactstrap';
import './CleaningStyle.css';
import Rooms from './Rooms';


class Cleaning extends Component {
    state = {
        collapse: null
    };

    toggle() {
        this.setState({ collapse: !this.state.collapse });
    }

    render() {
        return (
            <ListGroupItem >
                {/* fejléc rész */}
                <div style={cleaningStyle} onClick={() => {
                    this.toggle();
                }}>
                    <div style={itemStyle}>
                        <p style={dateStyle}>{this.props.cleaning.time}</p> {this.props.cleaning.scoutGroup.name} őrs
                        <p style={creatorStyle}>{this.props.cleaning.user.name}</p>
                    </div>
                    <svg className="bi bi-chevron-down" width="32" height="32" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fillRule="evenodd" d="M1.646 4.646a.5.5 0 01.708 0L8 10.293l5.646-5.647a.5.5 0 01.708.708l-6 6a.5.5 0 01-.708 0l-6-6a.5.5 0 010-.708z" clipRule="evenodd" />
                    </svg>
                    <div style={deleteButtonStyle}>
                    <button onClick={this.props.deleteCleaning.bind(this, this.props.cleaning.id)} type="button" className="btn btn-danger">X</button>
                </div>
                </div>
                {/* legördülő rész */}
                <Collapse isOpen={this.state.collapse}>
                    <div style={collapseStyle}>
                        <div style={itemStyle}>
                            <Rooms rooms={this.props.rooms}
                                cleaningId={this.props.cleaning.id} />
                        </div>
                    </div>
                </Collapse>
            </ListGroupItem>
        )
    }
}

//PropTypes
Cleaning.propTypes = {
    cleaning: PropTypes.object.isRequired,
    rooms: PropTypes.array.isRequired
}

const deleteButtonStyle = {
    flex: '1',
    margin: '16px 16px',
    fontWeight: 'bold',
    alignSelf: 'center',
    textAlign: 'center'
}

const cleaningStyle = {
    display: 'flex',
    flexDirection: 'row',
    backgroundColor: '#f4f4f4',
    textAlign: 'left',
    margin: '10px 30px'
}

const collapseStyle = {
    display: 'flex',
    flexDirection: 'row',
    backgroundColor: '#dbdbdb',
    textAlign: 'left',
    margin: '10px 30px'
}

const itemStyle = {
    flex: '6',
    margin: '16px 16px'
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
