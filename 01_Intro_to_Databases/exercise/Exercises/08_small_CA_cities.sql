-- 8. The name and population of cities in California (CA) with a population less than 150,000 people (37 rows)
Select city_name, population from city where (state_abbreviation = 'CA') AND (population < 150000);
