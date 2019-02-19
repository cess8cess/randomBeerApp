import React from 'react'

const Header = ({ onSearchSubmit }) => {
    return (
        <div className="ui clearing segment container" style={{ marginTop: '10px' }}>
            <h1 className="ui header center aligned" style={{ padding: '20px' }}>

                <div className="content">
                    The Random Beer App

                        <button
                        onClick={() => { onSearchSubmit(); }}
                        className="massive ui button"
                        style={{ marginLeft: '20px', boxShadow: '5px 10px #000' }}>
                        Show Another Beer
                        </button>
                </div>
            </h1>
        </div >
    )
}

export default Header
