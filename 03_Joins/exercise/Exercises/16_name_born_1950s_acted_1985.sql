-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

select distinct person_name, birthday
from person p
join movie_actor ma on person_id = ma.actor_id
join movie m using (movie_id)
where (release_date >= '1985-01-01' and release_date <= '1985-12-31') and (birthday >= '1950-01-01' and birthday <= '1959-12-31')