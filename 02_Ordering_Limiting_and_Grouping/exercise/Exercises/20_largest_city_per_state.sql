-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)

select state_abbreviation, max(population) as city_population from city group by state_abbreviation order by city_population desc