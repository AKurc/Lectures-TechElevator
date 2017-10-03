package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource(); //data source describing data we're connecting to
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource); //give data access object a connection to db
		
		City smallville = new City(); //new city object
		smallville.setId(6000L); //usually id comes from table, but set here because we just created it 
		//w/o it, cannot update anymore- could insert new record an insert from new record's id
		smallville.setCountryCode("USA");
		smallville.setDistrict("Kansas");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		//call a dao method to update the database
		
		//dao.save(smallville); //hey dao, save this city in the database as a new row in the db
		dao.update(smallville); //takes data on object, looks at id on row it needs to update, and updates row
		
		System.out.println(smallville); //in jdbccitydao.java added a city code
		
		City theCity = dao.findCityById(75);
		System.out.println(theCity.getName());
		
		List<City> allCitiesInCanada = dao.findCityByCountryCode("CAN");
		for(City thisOne : allCitiesInCanada) {
			thisOne.setName(thisOne.getName() + ", eh:");
			dao.update(thisOne); //update worked because all cities had an id LET DAO MESS WITH DATABASE, NOT YOU -id is link b/t db and object
		}
		
	}

}
