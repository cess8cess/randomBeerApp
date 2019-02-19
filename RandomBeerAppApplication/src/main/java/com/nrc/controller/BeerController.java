package com.nrc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrc.exception.BeerNotFoundException;
import com.nrc.model.Beer;
import com.nrc.service.IBeerService;

@RestController
@RequestMapping("v1")
public class BeerController {

	@Autowired
	IBeerService beerService;

	@PostMapping("beers")
	public Beer createBeer(@RequestBody Beer request) {
		Beer beer = new Beer();

		beer.setName(request.getName());
		beer.setDescription(request.getDescription());
		beer.setBreweryLocation(request.getBreweryLocation());
		beer.setAlcoholPercentage(request.getAlcoholPercentage());

		return beerService.createBeer(beer);

	}

	// retrieve all beers
	@GetMapping("beers")
	public List<Beer> getAllBeers() {
		return beerService.getBeers();
	}

	// retrieve individual beer
	@GetMapping("beers/{id}")
	public Beer getBeerById(@PathVariable String id) {
		return beerService.getBeerById(id).orElseThrow(BeerNotFoundException::new);
	}

	// delete individual beer
	@DeleteMapping("beers/{id}")
	public String deleteBeerById(@PathVariable String id) {
		Optional<Beer> beerOpt = beerService.getBeerById(id);

		return beerService.deleteBeer(beerOpt.orElseThrow(BeerNotFoundException::new));
	}

	// update individual beer
	@PutMapping("beers/{id}")
	public Beer updateBeerById(@PathVariable String id, @RequestBody Beer request) {
		Beer beer = beerService.getBeerById(id).orElseThrow(BeerNotFoundException::new);

		beer.setName(request.getName());
		beer.setDescription(request.getDescription());
		beer.setBreweryLocation(request.getBreweryLocation());
		beer.setAlcoholPercentage(request.getAlcoholPercentage());

		return beerService.updateBeer(beer);
	}

	@GetMapping("beers/random")
	public Beer getRandomBeer() {
		return beerService.getRandomBeer();
	}

}
