import React from 'react'

function Header() {
    return (
        <header>
            <nav className="navbar navbar-light bg-light">
                <a className="navbar-brand" style={headerStyle} href="/">
                    <img src={process.env.PUBLIC_URL + '/logo.png'} width="30" height="30" className="d-inline-block align-top" style={logoStyle} alt=""></img>
                    CsotthonApp
                </a>
            </nav>
        </header>
    )
}

const logoStyle = {
    marginRight: '5px',
}

const headerStyle = {
    color: '#545554',
    textShadow: '1.5px 1.5px 20px #517351'
}

export default Header;