import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import './HeaderStyle.css';
import PropTypes from 'prop-types';

class Header extends Component {

    onClick=(e)=>{
        this.props.logout();
    }

    render() {
        return(
            <header>
                <nav className="navbar navbar-light bg-light">
                    <a className="navbar-brand header" href="/">
                        <img src={process.env.PUBLIC_URL + '/logo.png'} width="30" height="30" className="d-inline-block align-top logo" alt=""></img>
                        CsotthonApp
                    </a>
                    { sessionStorage.getItem("authenticated")==='true' ? 
                    <Button className="button" type="button" variant="outlined" onClick={this.onClick}>Kilépés</Button> : 
                    ''}
                </nav>
            </header>
        )
    }
}

Header.propTypes = {
    logout: PropTypes.func.isRequired
}

export default Header;