import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';

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
            <form className="component component-create component-create-text" onSubmit={this.onSubmit}>
                <div className="form-group form-group-comp">
                    <label >Megjegyzés:</label>
                    <textarea className="form-control" name="comment" rows="2" value={this.state.comment} onChange={this.onChange} />
                </div>
                <button type="submit" className="btn btn-primary form-group-comp">Hozzáadás</button>
            </form>
        )
    }
}

CreateMaintenance.propTypes = {
    createMaintenance: PropTypes.func.isRequired
}


export default CreateMaintenance;
