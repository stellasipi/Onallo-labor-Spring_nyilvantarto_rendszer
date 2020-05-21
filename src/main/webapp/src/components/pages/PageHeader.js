import React , { Component }  from 'react'
import PropTypes from 'prop-types';

class PageHeader extends Component {
    render(){
        return (
        <div style={pageStyle}>
            {this.props.title}
        </div>
    )
    }
    
}

PageHeader.propTypes = {
    title: PropTypes.string.isRequired
}

const pageStyle = {
    backgroundColor: '#f4f4f4',
    textAlign: 'center',
    margin: '10px 30px',
    fontWeight: 'bold',
    fontVariant: 'small-caps',
    fontSize: '30px',
    paddingTop: '10px',
    paddingBottom: '10px'
}

export default PageHeader;
