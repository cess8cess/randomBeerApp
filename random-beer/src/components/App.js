import React, { Component } from 'react';
import beerApi from '../api/beerApi';

import BeerDetail from './BeerDetail'
import Header from './Header'

export default class App extends Component {
    state = { beer: {} }

    componentDidMount() {
        this.onSearchSubmit();
    }

    onSearchSubmit = async () => {
        const response = await beerApi.get('/beers/random');

        const { id, name, description, breweryLocation, alcoholPercentage } = response.data;
        this.setState({ beer: { id, name, description, breweryLocation, alcoholPercentage } });

    }

    render() {

        return (
            <>
                <Header onSearchSubmit={this.onSearchSubmit} />

                <BeerDetail beer={this.state.beer} />

            </>
        )
    }
}
