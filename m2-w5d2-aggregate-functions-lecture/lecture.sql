-- UPPER() LOWER() are for Strings only

-- LIKE
--is a way to do a really dumb search of string data- often used in website searches
--Ex: 
--like says look for wildcards %on L of word says continent has to end in america if 'North%; it must start with north or '%o%' is any continent that has an o in it
-- a blank space '% %' finds the space
--ONLY strings- not numbers-- and works on ROWS
-- SELECT * FROM country WHERE continent LIKE '%America';
SELECT * FROM country WHERE continent LIKE '%N%A%';

-- ORDERING RESULTS
--order by a certain column and then say ascending or descending order via ASC or DESC
-- Populations of all countries in descending order
SELECT population FROM country ORDER BY population DESC
--selects all columns
SELECT * FROM country ORDER BY population DESC
--select names- so you can see population of largest countries
SELECT name FROM country ORDER BY population DESC
-- not putting a DESC defaults to ASC order
SELECT name FROM country ORDER BY population

--Names of countries and continents in ascending order
--multiple name order by's
--second sort only works if there are no duplicates in first source => 2 tiered sort
SELECT name, continent FROM country ORDER BY continent ASC, name ASC


-- LIMITING RESULTS
--if you don't use LIMIT, it'll skip however many you offset it by => so in the example below, it will skip the first 10
--offset is all about skipping while limit is about getting that desired amount
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy IS NOT NULL ORDER BY lifeexpectancy DESC LIMIT 10 OFFSET 10

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington. 
-- || NOT OR it's concatenate 
-- "city, state", sorted by state then city
SELECT name || ',' || district FROM city WHERE district IN ('California', 'Oregon', 'Washington') 
--says same thing, just so much more clear!
--renaming it in results, building temporary tables-- an alias is very useful in an order by
-- iIN is the same thing as an OR statement
SELECT CONCAT (name, ',', district) AS city_state FROM city WHERE district IN ('California', 'Oregon', 'Washington') ORDER BY city_state ASC

--math functions:
--sort by negative number by using indepyear
SELECT * FROM country WHERE indepyear IS NOT NULL ORDER BY indepyear ASC
--absolute value is ABS()
SELECT name, ABS(indepyear) AS absolute_year FROM country WHERE indepyear IS NOT NULL ORDER BY indepyear ASC

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
--AVG aggregates into one number- ignores null automatically
SELECT AVG(lifeexpectancy) FROM country

-- Total population in Ohio
--note that in this database, state == district
-- SUM colapses them into one row and adds them up
SELECT SUM(population) FROM city WHERE district = 'Ohio'

-- The surface area of the smallest country in the world
-- MIN/MAX to get smallest/largest
--L of = is to give you the name- R of = gives just the country with the smallest country in the world
SELECT name, surfacearea FROM country WHERE surfacearea = (SELECT MIN(surfacearea) FROM country)

-- The 10 largest countries in the world - surface area
SELECT * FROM country ORDER BY surfacearea DESC LIMIT 10

-- The number of countries who declared independence in 1991
SELECT * FROM country WHERE indepyear = 1991
SELECT COUNT(*) FROM country WHERE indepyear = 1991
SELECT COUNT(*) AS num_of_countries FROM country WHERE indepyear = 1991

-- GROUP BY EXERCISES
-- Count the number of countries where each language is spoken, order show them from most countries to least
--uses countrylanguage table
SELECT countrycode, language FROM countrylanguage
SELECT COUNT(countrycode), language FROM countrylanguage GROUP BY language
SELECT COUNT(countrycode) AS countries_spoken, language FROM countrylanguage GROUP BY language ORDER BY countries_spoken DESC

-- Average life expectancy of each continent ordered from highest to lowest
--continued onto multiple lines for readability
SELECT AVG(lifeexpectancy) AS avg_life_expect, continent FROM country
GROUP BY continent ORDER BY avg_life_expect DESC

-- Exclude Antarctica from consideration for average life expectancy
SELECT AVG(lifeexpectancy) AS avg_life_expect, continent FROM country
WHERE lifeexpectancy IS NOT NULL
--or WHERE continent IS NOT 'Antarctica'
GROUP BY continent
ORDER BY avg_life_expect DESC

-- Sum of the population of cities in each state in the USA ordered by state name
--starting with single column and agregate column is how you know you need a group by 
SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district ASC 

-- The average population of cities in each state in the USA ordered by state name
SELECT UPPER(district), AVG(population)
FROM city
WHERE LOWER(countrycode) = 'usa'
GROUP BY district
ORDER BY district ASC

-- Additional samples
-- You may alias column and table names to provide more descriptive names
--SELECT name AS CityName FROM city AS cities;

-- Alias can also be used to create shorthand references, such c for city and co for country.
--pulling from two tables
SELECT c.name, co.name FROM city AS c, country AS co;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
--SELECT name, population FROM city WHERE countryCode='USA' ORDER BY name ASC, population DESC;

-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, and an optional OFFSET specifies number of rows to skip
--SELECT name, population FROM city LIMIT 10 OFFSET 10;

-- Postgres has a number of string functions like SUBSTR. It also supports string concatenation, so we can build completed sentences if desired
--SELECT (name || ' is in the state of ' || district) AS city_state FROM city WHERE countryCode='USA';

-- Aggregate functions provide the ability to COUNT, SUM, AVG, and determine MIN and MAX. Only returns a single row of value(s).
--SELECT COUNT(name) AS city_count FROM city;  -- Counts the number of rows
--SELECT COUNT(population) FROM city;		-- Counts the number of rows
--SELECT SUM(population) AS total_city_population, COUNT(population) as number_of_cities, AVG(population) AS avergage_population FROM city;
SELECT MIN(population) AS smallest_population, MAX(population) AS largest_population FROM city;

-- GROUP BY clusters rows by a column value
SELECT  countrycode, MIN(population), MAX(population) FROM city GROUP BY countrycode;
