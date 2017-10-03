package com.techelevator;

import java.math.BigDecimal;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class LectureExample {

	public static void main(String[] args) {
		BasicDataSource sqlDatasource = new BasicDataSource ();
		sqlDatasource.setUrl("jdbc:postgresql://localhost:5432/world");
		sqlDatasource.setUsername("postgres"); //set userId/username --password
		sqlDatasource.setPassword("password");
		//defines connections, but doesn't actually connect at this point
		//connections are finite in supply- so s/p using the connection, free it up
			//usually around 10 to same db as upperlimit to same-time connection => reuses as much as can
		
		JdbcTemplate worldConnection = new JdbcTemplate(sqlDatasource);
		
		String continent = "Africa";
		int minPopulation = 5000; //arguments do not have to be variables
		
		String sqlCountriesInNorthAmerica = "SELECT * FROM country WHERE continent =? AND population >= ?"; //sql statement is where you start
		//or SELECT name or SELECT population
			//let user decide where to pull country data from via a prepared statement -- ? is a placeholder for a prepared statement
				//don't need quotes around ?, db does it for you
		
		//worldConnection.queryForRowSet(sqlCountriesInNorthAmerica); //pass to sql db-- returns sql row set object
			//used when you're not getting multiple data results
		
		SqlRowSet countryRowSet = worldConnection.queryForRowSet(sqlCountriesInNorthAmerica, continent, minPopulation);   //need to put that row set into a variable
		// takes string, finds question mark, puts next query into question mark
		
		//all data is still on the sql row set until we ask for it:
		//.next goes and requests row from server and loads it into the sql object so we can access data:
		// with each subsequent .next, throws out old row and plugs new row in
		while(countryRowSet.next()) { 
			//System.out.println(countryRowSet.getString("name") ); // ask row set for data in the type of data you'd like to convert to:
			String name = countryRowSet.getString("name");
			int population = countryRowSet.getInt("population");
			BigDecimal gnp = countryRowSet.getBigDecimal("gnp"); //gnp is a numeric which is an exact decimal type => that's how we know to use BigDecimal
			
			System.out.println(name + " - " + population + " - " + gnp);
		
		}
		
		String sqlCountCountriesInContinent = "SELECT COUNT(*) FROM country WHERE continent =? AND population >= ?";
		
		int countOfCountries = worldConnection.queryForObject(sqlCountCountriesInContinent, Integer.class, continent, minPopulation); 
		//takes sql we want to run, what object we expect back
		//for object takes sql, classOfObject, parameter1...
		
		System.out.println("Number of countries was: " + countOfCountries);
		
		String sqlCreateCity = "INSERT INTO city (id, name, countrycode, district, population) VALUES (?,?,?,?,?)";
		//INSERT into city those values
		//update runs sql statement but doesn't expect anything back =>creates Joeville with a pop of 1
		
		worldConnection.update(sqlCreateCity, 5500, "Joeville", "USA", "Ohio", 1); //pass sql then 5 parameters
	}
	
	BasicDataSource sqlDVDDatasource = new BasicDataSource();
	sqlDVDDatasource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
	sqlDVDDatasource.setUsername("postgres");
	sqlDVDDatasource.setPassword("password");
	
	JdbcTemplate worldConnection = new JdbcTemplate(sqlDVDDatasource);
	
	String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES (?,?) RETURNING actor_id";
	int newActorId = dvdConnection.queryForObject(sqlCreateActor, Integer.class, "Joe", "Erickson");
	
	System.out.println("New actor is:"+ newActorId);
}
