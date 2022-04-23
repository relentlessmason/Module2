-- 14. The state name, nickname, and census region for states that start with the word "New" (4 rows)

select state_nickname, state_name, census_region from state where state_name like 'New%'