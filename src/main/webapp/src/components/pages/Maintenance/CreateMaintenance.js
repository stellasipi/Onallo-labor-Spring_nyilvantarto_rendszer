import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import './MaintenanceStyle.css'
import swal from 'sweetalert';

class CreateMaintenance extends Component {
    state = {
        comment: ''
    }

    onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    onSubmit = (e) => {
        e.preventDefault();
        if(this.state.comment!==""){
            //pass fields
            this.props.createMaintenance(this.state.comment, this.state.userId);

            //clear fields
            this.setState({ comment: '' }); 
            swal({
                title: "Hozzáadva",
                icon: "success",
                timer: 1500
            });
        }else{
            swal("Upsz!", "A megjegyzés mező nem lehet üres", "error");
        }
    }

    render() {
        return (
            <form className="component component-create component-create-text" onSubmit={this.onSubmit}>
                <div className="create-text-mt">
                    <div className="create-header-mt">Megjegyzés:</div> 
                    <TextField id="component-create-text-field" name="comment" multiline rows={5} variant="outlined" value={this.state.comment} onChange={this.onChange} />
                    <Button variant="outlined" type="submit">Hozzáadás</Button>
                </div>
            </form>
        )
    }
}

CreateMaintenance.propTypes = {
    createMaintenance: PropTypes.func.isRequired
}


export default CreateMaintenance;
