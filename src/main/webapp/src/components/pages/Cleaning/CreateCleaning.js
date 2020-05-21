import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './CleaningStyle.css';
//import CreateCleaningRooms from './CreateCleaningRooms'

class CreateCleaning extends Component {
    state = {
        pince_rekeszek_name: 'rekeszek', pince_rekeszek_done: '',
        pince_felmosas_name: 'felmosás', pince_felmosas_done: '',

        nagyTerem_lomok_name: 'lomok', nagyTerem_lomok_done: '',
        nagyTerem_elrendezes_name: 'elrendezés', nagyTerem_elrendezes_done: '',
        nagyTerem_felmosas_name: 'felmosás', nagyTerem_felmosas_done: '',

        konyha_konyhapult_name: 'konyhapult', konyha_konyhapult_done: '',
        konyha_konyhabutor_name: 'konyhabútor', konyha_konyhabutor_done: '',
        konyha_mosogatas_name: 'mosogatás', konyha_mosogatas_done: '',
        konyha_felmosas_name: 'felmosás', konyha_felmosas_done: '',

        kozepsoTerem_elrendezes_name: 'elrendezés', kozepsoTerem_elrendezes_done: '',
        kozepsoTerem_faliujsag_name: 'faliujság', kozepsoTerem_faliujsag_done: '',
        kozepsoTerem_vitrin_name: 'vitrin', kozepsoTerem_vitrin_done: '',
        kozepsoTerem_raktar_name: 'raktár', kozepsoTerem_raktar_done: '',
        kozepsoTerem_felmosas_name: 'felmosás', kozepsoTerem_felmosas_done: '',

        mosdok_tisztaKagylok_name: 'tiszta kagylók', mosdok_tisztaKagylok_done: '',
        mosdok_wcpapir_name: 'wcpapír', mosdok_wcpapir_done: '',
        mosdok_torulkozo_name: 'törülköző', mosdok_torulkozo_done: '',
        mosdok_felmosas_name: 'felmosás', mosdok_felmosas_done: ''
    }

    onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.checked
        })
    }

    onSubmit = (e) => {
        e.preventDefault();
        //pass fields
        this.props.createCleaning(
            this.state.pince_rekeszek_name, this.state.pince_rekeszek_done,
            this.state.pince_felmosas_name, this.state.pince_felmosas_done,
            this.state.nagyTerem_lomok_name, this.state.nagyTerem_lomok_done,
            this.state.nagyTerem_elrendezes_name, this.state.nagyTerem_elrendezes_done,
            this.state.nagyTerem_felmosas_name, this.state.nagyTerem_felmosas_done,
            this.state.konyha_konyhapult_name, this.state.konyha_konyhapult_done,
            this.state.konyha_konyhabutor_name, this.state.konyha_konyhabutor_done,
            this.state.konyha_mosogatas_name, this.state.konyha_mosogatas_done,
            this.state.konyha_felmosas_name, this.state.konyha_felmosas_done,
            this.state.kozepsoTerem_elrendezes_name, this.state.kozepsoTerem_elrendezes_done,
            this.state.kozepsoTerem_faliujsag_name, this.state.kozepsoTerem_faliujsag_done,
            this.state.kozepsoTerem_vitrin_name, this.state.kozepsoTerem_vitrin_done,
            this.state.kozepsoTerem_raktar_name, this.state.kozepsoTerem_raktar_done,
            this.state.kozepsoTerem_felmosas_name, this.state.kozepsoTerem_felmosas_done,
            this.state.mosdok_tisztaKagylok_name, this.state.mosdok_tisztaKagylok_done,
            this.state.mosdok_wcpapir_name, this.state.mosdok_wcpapir_done,
            this.state.mosdok_torulkozo_name, this.state.mosdok_torulkozo_done,
            this.state.mosdok_felmosas_name, this.state.mosdok_felmosas_done
        );

        //clear fields
        this.setState({
            pince_rekeszek_done: '',
            pince_felmosas_done: '',
            nagyTerem_lomok_done: '',
            nagyTerem_elrendezes_done: '',
            nagyTerem_felmosas_done: '',
            konyha_konyhapult_done: '',
            konyha_konyhabutor_done: '',
            konyha_mosogatas_done: '',
            konyha_felmosas_done: '',
            kozepsoTerem_elrendezes_done: '',
            kozepsoTerem_faliujsag_done: '',
            kozepsoTerem_vitrin_done: '',
            kozepsoTerem_raktar_done: '',
            kozepsoTerem_felmosas_done: '',
            mosdok_tisztaKagylok_done: '',
            mosdok_wcpapir_done: '',
            mosdok_torulkozo_done: '',
            mosdok_felmosas_done: '',
        })
    }

    /*addRooms = (pince, nagyTerem, konyha, kozepsoTerem, mosdok) => {
        this.state.postableRoomCleanings.push(pince);
        this.state.postableRoomCleanings.push(nagyTerem);
        this.state.postableRoomCleanings.push(konyha);
        this.state.postableRoomCleanings.push(kozepsoTerem);
        this.state.postableRoomCleanings.push(mosdok);
    }*/

    render() {
        return (
            <form style={cleaningStyle} onSubmit={this.onSubmit}>
                <div className="form-group" style={formGroupStyle}>
                    <div>
                        <div style={roomNameStyle}>Pince</div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="pince_rekeszek_done" checked={this.state.pince_rekeszek_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.pince_rekeszek_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="pince_felmosas_done" checked={this.state.pince_felmosas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.pince_felmosas_name}</label>
                        </div>
                    </div>
                    <div>
                        <div style={roomNameStyle}>Nagy terem</div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="nagyTerem_lomok_done" checked={this.state.nagyTerem_lomok_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem_lomok_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="nagyTerem_elrendezes_done" checked={this.state.nagyTerem_elrendezes_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem_elrendezes_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="nagyTerem_felmosas_done" checked={this.state.nagyTerem_felmosas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.nagyTerem_felmosas_name}</label>
                        </div>
                    </div>
                    <div>
                        <div style={roomNameStyle}>Konyha</div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="konyha_konyhapult_done" checked={this.state.konyha_konyhapult_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha_konyhapult_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="konyha_konyhabutor_done" checked={this.state.konyha_konyhabutor_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha_konyhabutor_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="konyha_mosogatas_done" checked={this.state.konyha_mosogatas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha_mosogatas_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="konyha_felmosas_done" checked={this.state.konyha_felmosas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.konyha_felmosas_name}</label>
                        </div>
                    </div>
                    <div>
                        <div style={roomNameStyle}>Középső terem</div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="kozepsoTerem_elrendezes_done" checked={this.state.kozepsoTerem_elrendezes_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem_elrendezes_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="kozepsoTerem_faliujsag_done" checked={this.state.kozepsoTerem_faliujsag_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem_faliujsag_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="kozepsoTerem_vitrin_done" checked={this.state.kozepsoTerem_vitrin_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem_vitrin_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="kozepsoTerem_raktar_done" checked={this.state.kozepsoTerem_raktar_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem_raktar_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="kozepsoTerem_felmosas_done" checked={this.state.kozepsoTerem_felmosas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.kozepsoTerem_felmosas_name}</label>
                        </div>
                    </div>
                    <div>
                        <div style={roomNameStyle}>Mosdók</div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="mosdok_tisztaKagylok_done" checked={this.state.mosdok_tisztaKagylok_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok_tisztaKagylok_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="mosdok_wcpapir_done" checked={this.state.mosdok_wcpapir_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok_wcpapir_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="mosdok_torulkozo_done" checked={this.state.mosdok_torulkozo_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok_torulkozo_name}</label>
                        </div>
                        <div className="form-check"  >
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"
                                name="mosdok_felmosas_done" checked={this.state.mosdok_felmosas_done} onChange={(e) => this.onChange(e)} />
                            <label className="form-check-label" htmlFor="exampleCheck1">{this.state.mosdok_felmosas_name}</label>
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
