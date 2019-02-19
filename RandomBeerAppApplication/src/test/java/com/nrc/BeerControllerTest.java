package com.nrc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nrc.controller.BeerController;
import com.nrc.model.Beer;
import com.nrc.service.IBeerService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BeerControllerTest {

	private MockMvc mockMvc;

	@Mock
	IBeerService beerService;

	@InjectMocks
	BeerController beerController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(beerController).build();
	}

	@Test
	public void testGetRandomBeer() throws Exception {
		when(beerService.getRandomBeer()).thenReturn(produceBeer());
		String expected = "{\"id\":\"1\",\"name\":\"Guiness\",\"description\":\"Description\",\"alcoholPercentage\":\"4.0\",\"breweryLocation\":\"Ireland\"}";
		String actual = mockMvc.perform(get("/v1/beers/random")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		assertEquals(expected, actual);
	}

	private Beer produceBeer() {
		Beer beer = new Beer();
		beer.setId("1");
		beer.setName("Guiness");
		beer.setDescription("Description");
		beer.setAlcoholPercentage("4.0");
		beer.setBreweryLocation("Ireland");
		return beer;
	}

}
