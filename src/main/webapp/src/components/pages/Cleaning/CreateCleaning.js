import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './CleaningStyle.css';

class CreateCleaning extends Component {
    state = {
        pince: [
            { cleaningItemName: 'rekeszek', done: '' },
            { cleaningItemName: 'felmosás', done: '' }
        ],
        nagyTerem: [
            { cleaningItemName: 'lomok', done: '' },
            { cleaningItemName: 'elrendezés', done: '' },
            { cleaningItemName: 'felmosás', done: '' }
        ],
        konyha: [
            { cleaningItemName: 'konyhapult', done: '' },
            { cleaningItemName: 'konyhabútor', done: '' },
            { cleaningItemName: 'mosogatás', done: '' },
            { cleaningItemName: 'felmosás', done: '' },
        ],
        kozepsoTerem: [
            { cleaningItemName: 'elrendezés', done: '' },
            { cleaningItemName: 'faliujság', done: '' },
            { cleaningItemName: 'vitrin', done: '' },
            { cleaningItemName: 'raktár', done: '' },
            { cleaningItemName: 'felmosás', done: '' }
        ],
        mosdok: [
            { cleaningItemName: 'tiszta kagylók', done: '' },
            { cleaningItemName: 'wcpapír', done: '' },
            { cleaningItemName: 'törülköző', done: '' },
            { cleaningItemName: 'felmosás', done: '' }
        ]
    }

    onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    onSubmit = (e) => {
        /*e.preventDefault();
        //pass fields
        this.props.createCleaning(this.state.comment, this.state.userId);

        //clear fields
        this.setState({ comment: '' })*/ 
    }

    render() {
        return (
            <form style={cleaningStyle} onSubmit={this.onSubmit}>
                <div className="form-group" style={formGroupStyle}>
                    {/* <label >Megjegyzés:</label>
                    <textarea className="form-control" name="comment" rows="2" value={this.state.comment} onChange={this.onChange} /> */}
                    <div>
                        <div style={roomNameStyle}>Pince</div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1" name='pince[0].done' value={this.state.pince[0].done} onChange={this.onChange}/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.pince[0].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.pince[1].cleaningItemName}</label>
                            </div>
                        </div>
                        <div>
                            <div style={roomNameStyle}>Nagy terem</div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem[0].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem[1].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem[2].cleaningItemName}</label>
                            </div>
                        </div>
                        <div>
                            <div style={roomNameStyle}>Konyha</div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha[0].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha[1].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha[2].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha[3].cleaningItemName}</label>
                            </div>
                        </div>
                        <div>
                            <div style={roomNameStyle}>Középső terem</div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem[0].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem[1].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem[2].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem[3].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem[4].cleaningItemName}</label>
                            </div>
                        </div>
                        <div>
                            <div style={roomNameStyle}>Mosdók</div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok[0].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok[1].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok[2].cleaningItemName}</label>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                                    <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok[3].cleaningItemName}</label>
                            </div>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-primary" style={formGroupStyle}>Hozzáadás</button>
            </form>
        )
    }
}

const roomNameStyle = {
                    fontWeight: 'bold',
    marginBottom: '8px',
    marginTop: '8px'
}

const cleaningStyle = {
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

CreateCleaning.propTypes = {
                    createCleaning: PropTypes.func.isRequired
}

export default CreateCleaning;
