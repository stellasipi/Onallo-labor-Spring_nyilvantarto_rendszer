import React, { Component } from 'react'
//import PropTypes from 'prop-types';

class CreateLog extends Component {
    state = {
        type: '',
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
        this.props.createLog(this.state.type, this.state.comment,this.state.userId);

        //clear fields
        this.setState({ type: '', comment: '' })
    }

    render() {
        return (
            
                <form style={logStyle} onSubmit={this.onSubmit}>
                    <div className="form-group" style={formGroupStyle}>
                        <label >Válaszd ki, hogy nyitottál vagy zártál?</label>
                        <select className="form-control" name="type" value={this.state.type} onChange={this.onChange} required>
                            <option></option>
                            <option value='OPENING'>Nyitás</option>
                            <option value='CLOSING'>Zárás</option> 
                        </select>
                    </div>  
                    <div className="form-group" style={formGroupStyle}>
                        <label >Megjegyzés:</label>
                        <textarea className="form-control" name="comment" rows="2" value={this.state.comment} onChange={this.onChange}/>
                    </div>
                    <button  type="submit" className="btn btn-primary" style={formGroupStyle}>Hozzáadás</button>
                </form>
                
            
        )
    }
}

const logStyle = {
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

//PropTypes
// Log.propTypes = {
//     log: PropTypes.object.isRequired
// }

export default CreateLog
