import React, { Component } from 'react'
import PropTypes from 'prop-types';
import './../../layouts/ComponentSytle.css';

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
        this.props.createLog(this.state.type, this.state.comment);

        //clear fields
        this.setState({ type: '', comment: '' })
    }

    render() {
        return (
            
                <form className="component component-create" onSubmit={this.onSubmit}>
                    <div className="form-group form-group-comp">
                        <label >Válaszd ki, hogy nyitottál vagy zártál?</label>
                        <select className="form-control" name="type" value={this.state.type} onChange={this.onChange} required>
                            <option></option>
                            <option value='OPENING'>Nyitás</option>
                            <option value='CLOSING'>Zárás</option> 
                        </select>
                    </div>  
                    <div className="form-group form-group-comp" >
                        <label >Megjegyzés:</label>
                        <textarea className="form-control" name="comment" rows="2" value={this.state.comment} onChange={this.onChange}/>
                    </div>
                    <button  type="submit" className="btn btn-primary form-group-comp">Hozzáadás</button>
                </form>
                
            
        )
    }
}

CreateLog.propTypes = {
    createLog: PropTypes.func.isRequired
  }

export default CreateLog
