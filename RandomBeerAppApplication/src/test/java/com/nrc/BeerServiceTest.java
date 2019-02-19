package com.nrc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.nrc.model.Beer;
import com.nrc.repo.BeerRepository;
import com.nrc.service.BeerService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RandomBeerAppApplicationTests.class)
public class BeerServiceTest {

	@Mock
	BeerRepository beerRepository;

	@InjectMocks
	BeerService beerService;

	@Test
	public void testGetBeerById() throws Exception {
		Optional<Beer> expected = produceBeer();
		when(beerRepository.findById("1")).thenReturn(expected);
		Optional<Beer> actual = beerService.getBeerById("1");
		assertEquals(expected.get().getAlcoholPercentage(), actual.get().getAlcoholPercentage());
		assertEquals(expected.get().getBreweryLocation(), actual.get().getBreweryLocation());
		assertEquals(expected.get().getDescription(), actual.get().getDescription());
		assertEquals(expected.get().getName(), actual.get().getName());
		assertEquals(expected.get().getId(), actual.get().getId());
	}

	@Test
	public void testRandomBeer() throws Exception {
		Beer expected = produceBeer().get();
		List<Beer> list = new ArrayList<Beer>();
		list.add(expected);
		when(beerRepository.findAll()).thenReturn(list);
		Beer actual = beerService.getRandomBeer();
		assertEquals(expected.getAlcoholPercentage(), actual.getAlcoholPercentage());
		assertEquals(expected.getBreweryLocation(), actual.getBreweryLocation());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getId(), actual.getId());
	}

	private Optional<Beer> produceBeer() {
		Beer beer = new Beer();
		beer.setId("1");
		beer.setName("Guiness");
		beer.setDescription("Description");
		beer.setAlcoholPercentage("4.0");
		beer.setBreweryLocation("Ireland");
		return Optional.of(beer);
	}
}
