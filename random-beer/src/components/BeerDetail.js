import React, { Component } from 'react'

class BeerDetail extends Component {
    render() {

        if (!this.props.beer) {
            return (
                <div className="ui segment">
                    <div className="ui active dimmer">
                        <div className="ui indeterminate text loader">Fetching Random Beer ...</div>
                    </div>
                    <p></p>
                </div>
            )
        }

        const { name, description, alcoholPercentage, breweryLocation } = this.props.beer;
        return (
            <div className="ui container">
                <div className="ui items">
                    <div className="item ">
                        <div className="ui bottom aligned  medium rounded image">
                            <img src="beer.jpg" alt="alt" />
                        </div>

                        <div className="content bottom aligned">
                            <div className="ui segment container header">{name}</div>

                            <div className="ui segment container description">
                                <p>
                                    {description}
                                </p>

                                <p>
                                    <b>Alcohol Percentage:</b> {alcoholPercentage} <br>
                                    </br>
                                    <b>Brewery Location:</b> {breweryLocation}
                                </p>
                            </div>

                        </div>

                    </div>
                </div>
            </div >
        )
    }
}

BeerDetail.defaultProps = {
    beer: {
        name: 'Mythos',
        description: 'Mythos Brewery (lit. myth) is the second largest Greek brewery, best known for its Mythos brand. The company, a subsidiary of Carlsberg since 2008, also imports a number of non-Greek beers into the country. The main production plant is located in Thessaloniki ',
        alcoholPercentage: '4.3',
        breweryLocation: 'Thessaloniki'
    }

};

export default BeerDetail;