package com.nrc.service;

import java.util.List;
import java.util.Optional;

import com.nrc.model.Beer;

public interface IBeerService {
	public Optional<Beer> getBeerById(String id);

	public Beer createBeer(Beer beer);

	public String deleteBeer(Beer beer);

	public Beer updateBeer(Beer beer);

	public List<Beer> getBeers();

	public Beer getRandomBeer();
}
