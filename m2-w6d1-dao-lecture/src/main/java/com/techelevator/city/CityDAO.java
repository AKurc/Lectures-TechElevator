package com.techelevator.city;

import java.util.List;

public interface CityDAO {
									//Uses CRUD acronym
	public void save(City newCity); //Create
	public City findCityById(long id); //Retrieve
	public List<City> findCityByCountryCode(String countryCode); //Retrieve
	public List<City> findCityByDistrict(String district); //Retrieve
	public void update(City city); //Update
	public void delete(long id); //Delete
}
