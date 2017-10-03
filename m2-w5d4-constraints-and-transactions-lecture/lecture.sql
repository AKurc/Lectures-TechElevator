
-- INSERT DATA
-- Let's add Klingon to the languages in the database.
-- => insert a row into a a database 
--  Don't have a country code handy, and not sure about whether its an offical language anywhere, or the percentage of people who speak,
-- but I want to get it into the database before I forget.
INSERT INTO countrylanguage (language) VALUES ('Klingon')
--doesn't work b/c the tble req it to not be null => must define every single column before insert

-- That wasn't very friendly.
-- But I really want to get the record into the table, so I'll use a made up countrycode,
-- and guess that its likely not an official language anywhere, and the percentage is near enough to zero, that its ok to specify that.
--must be very specific to order of column 
--KRO doesn't exist => still doesn't work
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) 
VALUES ('Klingon', 'KRO', false, 0)


-- Referential integrity requires that foreign keys point to valid primary keys. There is no country with a code of XQR in the database
-- Since Star Trek is an American TV show, let's set the countrylanguage.countrycode to 'USA', and hope it all works out.
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) 
VALUES ('Klingon', 'USA', false, 0)

-- let's confirm
SELECT * FROM countrylanguage WHERE language = 'Klingon'

-- Add the exciting new language, Klinglish.
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) 
VALUES ('Klinglish', 'USA', false, 0)

-- You can also rearrange the column names in the list, you just need to make sure the values match.


-- DELETE
--DO A SELECT * BEFORE A DELETE
-- Let's delete all the Klingon, Klingish, and Englon rows we just added, starting with Englon.
DELETE FROM countrylanguage WHERE language = 'Klingon' OR language = 'Klinglish'

-- Then a simple select to confirm the deletion
SELECT * FROM countrylanguage WHERE language = 'Klingon' OR language = 'Klinglish'

-- The WHERE clause can have other conditions besides equals. 
 -- We can could do `language='Klingon' or language='Klinglish'`. 
 -- We might even do something daring, `'language LIKE 'Kling%'`, and remove the rows with a wildcard LIKE.  
 -- BETWEEN n AND n+1` is also a really handy technique for deleting rows within a range of values, such numeric keys.


-- The last deletion exercise demonstrates referential integrity.
-- Confirm the county.captial for USA is Washington.
SELECT capital FROM country WHERE code = 'USA'

-- Remember, country.capital is a foreign key pointing to city.id.  Attempting to delete Washington from the city table
-- using its id will violate referential integrity, and the deletion will not be allowed.
--doesn't work because city is set to capital in database
DELETE FROM city WHERE id= 3813


-- UPDATE
-- Let's start by adding back Klingon.
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) 
VALUES ('Klingon', 'USA', false, 0)

SELECT * FROM countrylanguage WHERE language = 'Klingon'

-- And just in time, because Klingon is now an official language in the US, and is spoken by 2 percent of the population.
UPDATE countrylanguage 
SET isofficial = true, percentage = 2 
WHERE language = 'Klingon' AND countrycode = 'USA' 


-- TRANSACTIONS
-- Let's wrap updating the Klingon row in a trasaction. Begin by noting the current values for isofficial and percentage.
--****** VIP
BEGIN TRANSACTION;

UPDATE countrylanguage
SET isofficial = false, percentage = 4, countrycode = 'XYZ'
WHERE language = 'Klingon' AND countrycode = 'USA' ;

COMMIT;

ROLLBACK;

-- Now start the transaction, change isofficial and percentage, and then commit.


-- Confirm the commited transaction took place.


-- Repeat with new values for isoficial and percentage, and this time rollback the tranaction.


-- Finally, confirm that the changes were not committed, but were rolled back.