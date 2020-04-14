import React from 'react'

function Header() {
    return (
        <header>
            <nav className="navbar navbar-light bg-light">
                <a className="navbar-brand" href="/">
                    <img src={process.env.PUBLIC_URL + '/logo.png'} width="30" height="30" className="d-inline-block align-top" style = {headerStyle} alt=""></img>
                    CsotthonApp
                </a>
            </nav>
        </header>
    )
}

const headerStyle = {
    marginRight: '5px'
}

export default Header;