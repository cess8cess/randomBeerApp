package com.nrc.model;

import org.springframework.data.annotation.Id;

public class Beer {
	@Id
	private String id;

	private String name;

	private String description;

	private String alcoholPercentage;

	private String breweryLocation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlcoholPercentage() {
		return alcoholPercentage;
	}

	public void setAlcoholPercentage(String alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}

	public String getBreweryLocation() {
		return breweryLocation;
	}

	public void setBreweryLocation(String breweryLocation) {
		this.breweryLocation = breweryLocation;
	}

}
