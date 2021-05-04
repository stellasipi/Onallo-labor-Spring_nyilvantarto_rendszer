import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import './LogStyle.css'
import swal from 'sweetalert';

class CreateLog extends Component {
    state = {
        type: '',
        comment: ''
    }

    onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }   

    onSubmit = (e) => {
        e.preventDefault();
        //pass fields
        if(this.state.type!==''){
            this.props.createLog(this.state.type, this.state.comment);

            //clear fields
            this.setState({ type: '', comment: '' })

            swal({
                title: "Hozzáadva",
                icon: "success",
                timer: 1500
            });
        }else{
            swal("Upsz!", "Nem választottad ki, hogy nyitottál vagy zártál!", "error");
        }
    }

    render() {
        return (
            
                <form className="component component-create" onSubmit={this.onSubmit}>
                    <div className="create-select-log">
                        <div className="create-header-log">Válaszd ki, hogy nyitottál vagy zártál?</div> 
                        <FormControl id="select-log">
                            <Select name="type" value={this.state.type} onChange={this.onChange}>
                                <MenuItem value='OPENING'>Nyitás</MenuItem>
                                <MenuItem value='CLOSING'>Zárás</MenuItem>
                            </Select>
                        </FormControl>
                    </div>  
                    <div className="create-text-log">
                        <div className="create-header-log">Megjegyzés:</div> 
                        <TextField id="component-create-text-field" name="comment" multiline rows={5} variant="outlined" value={this.state.comment} onChange={this.onChange} />
                        <Button variant="outlined" type="submit">Hozzáadás</Button>
                    </div>
                </form>
                
            
        )
    }
}

CreateLog.propTypes = {
    createLog: PropTypes.func.isRequired
  }

export default CreateLog
