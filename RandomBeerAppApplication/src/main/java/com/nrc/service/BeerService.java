package com.nrc.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrc.exception.BeerNotFoundException;
import com.nrc.model.Beer;
import com.nrc.repo.BeerRepository;

@Service
public class BeerService implements IBeerService {

	@Autowired
	BeerRepository beerRepository;

	@Override
	public Beer createBeer(Beer beer) {
		return beerRepository.save(beer);
	}

	@Override
	public Optional<Beer> getBeerById(String id) {
		return beerRepository.findById(id);
	}

	@Override
	public String deleteBeer(Beer beer) {
		beerRepository.delete(beer);
		return beer.getId();
	}

	@Override
	public Beer updateBeer(Beer beer) {
		return beerRepository.save(beer);
	}

	@Override
	public List<Beer> getBeers() {
		return beerRepository.findAll();
	}

	@Override
	public Beer getRandomBeer() throws BeerNotFoundException {
		List<Beer> beers = getBeers();

		if (beers == null || beers.size() == 0) {
			throw new BeerNotFoundException();
		}

		return beers.stream().skip(new Random().nextInt(beers.size())).findFirst().get();
	}

}
