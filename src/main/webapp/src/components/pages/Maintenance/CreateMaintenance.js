import React, { Component } from 'react';
import PropTypes from 'prop-types';

class CreateMaintenance extends Component {
    state = {
        comment: '',
        userId: '2' //majd javítani
    }

    onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    onSubmit = (e) => {
        e.preventDefault();
        //pass fields
        this.props.createMaintenance(this.state.comment, this.state.userId);

        //clear fields
        this.setState({ comment: '' })
    }

    render() {
        return (
            <form style={maintenanceStyle} onSubmit={this.onSubmit}>
                <div className="form-group" style={formGroupStyle}>
                    <label >Megjegyzés:</label>
                    <textarea className="form-control" name="comment" rows="2" value={this.state.comment} onChange={this.onChange} />
                </div>
                <button type="submit" className="btn btn-primary" style={formGroupStyle}>Hozzáadás</button>
            </form>
        )
    }
}

const maintenanceStyle = {
    display: 'flex',
    flexDirection: 'column',
    backgroundColor: '#f4f4f4',
    textAlign: 'center',
    margin: '10px 30px',
}

const formGroupStyle = {
    flex: '1',
    margin: '16px 16px',
    alignSelf: 'center',
    width: '80%'
}

CreateMaintenance.propTypes = {
    createMaintenance: PropTypes.func.isRequired
}


export default CreateMaintenance;
