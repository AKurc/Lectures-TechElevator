-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT * FROM payment WHERE payment_id = 16666;


-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
--join other tables s/p select and from => join this other table ON this criteria
-- ***JOIN table2 ON table.id = table_2.other_id
--have to say table name because they both have a customer id
SELECT * FROM payment AS P
JOIN customer AS c ON p.customer_id = c.customer_id
WHERE payment_id = 16666;

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT p.*, c.first_name, c.last_name FROM payment AS P
JOIN customer AS c ON p.customer_id = c.customer_id
WHERE payment_id = 16666;

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.
SELECT p.*, c.first_name, c.last_name, r.return_date FROM payment AS P
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental r ON r.rental_id = p.rental_id
WHERE payment_id = 16666;

-- What did they rent? Film id can be gotten through inventory.
--so if we link from rental to inventory, we can link from inventory to film
SELECT p.*, c.first_name, c.last_name, r.return_date, f.title FROM payment AS P
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
WHERE payment_id = 16666;

-- What if we wanted to know who acted in that film?  
SELECT p.*, c.first_name, c.last_name, r.return_date, f.title, a.first_name, a.last_name FROM payment AS P
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
JOIN film_actor fa ON fa.film_id = f.film_id
JOIN actor a ON a.actor_id = fa.actor_id
WHERE payment_id = 16666;  

-- What if we wanted a list of all the films and their categories ordered by film title
-- start at table pulling most data from OR where you have the where clause
--by default order by is last updated
--direction you traverse your tables does NOT matter
--SELECT f.title, c.name FROM film f
--JOIN film_category fc ON fc.film_id = f.film_id
--JOIN category c ON c.category_id = fc.category_id
--ORDER BY f.title;
SELECT f.title, c.name FROM film f
JOIN film_category fc ON fc.film_id = c.category_id
JOIN category c ON fc.category_id = f.film_id
ORDER BY f.title;


-- Show all the 'Comedy' films ordered by film title

-- Finally, let's count the number of films under each category
SELECT name, COUNT(*)
FROM category
JOIN film_category ON category.category_id = film_category.category_id
GROUP BY category.category_id;



-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists. 


--*** make sure to switch the database connection 
--Let's display a list of all countries and their capitals, if they have some.
SELECT c. name, ci.name
FROM country c
LEFT JOIN city ci ON c.capital = ci.id
--only 232 rows
--but we're missing entires:
SELECT COUNT (*) FROM country;
-- Only 232 rows
-- But we’re missing entries:

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
--pretty much never every use it
SELECT first_name FROM actor
UNION 
SELECT first_name FROM customer
--ORDER BY first_name;

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
SELECT first_name, 'A' FROM actor
UNION
SELECT first_name, 'C' FROM customer
ORDER BY first_name;