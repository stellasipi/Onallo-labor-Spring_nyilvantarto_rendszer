import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import './HeaderStyle.css';
import PropTypes from 'prop-types';

class Header extends Component {

    onLogout=(e)=>{
        this.props.logout();
    }

    goBack() {
        if(sessionStorage.getItem("registration")==='true'){
            sessionStorage.setItem("registration",false);
        }
        window.history.back()
    }

    render() {
        return(
            <header>
                <nav className="navbar navbar-light bg-light">
                    <div>
                        <a className="navbar-brand header" href="/">
                            <img src={process.env.PUBLIC_URL + '/logo.png'} width="30" height="30" className="d-inline-block align-top logo" alt=""></img>
                            CsotthonApp
                        </a>
                    </div>
                    <div>
                        { sessionStorage.getItem("registration")==='true' || localStorage.getItem("authenticated")==='true' ? 
                        <Button className="def-button back-button" type="button" variant="outlined" href="/login" onClick={this.goBack}>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-chevron-compact-left" viewBox="0 0 16 16">
                                <path fillRule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
                            </svg>
                        </Button> : 
                        ''}
                        { localStorage.getItem("authenticated")==='true' ? 
                        <Button className="def-button" type="button" variant="outlined" onClick={this.onLogout}>Kilépés</Button> : 
                        ''}
                    </div>
                </nav>
            </header>
        )
    }
}

Header.propTypes = {
    logout: PropTypes.func.isRequired
}

export default Header;