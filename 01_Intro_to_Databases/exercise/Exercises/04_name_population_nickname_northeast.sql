-- 4. The name, population, and nickname of the states in the "Northeast" census region (9 rows)
Select state_name, population, state_nickname From state Where census_region = 'Northeast';
