-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)

select distinct genre_name
from genre g
join movie_genre mg using (genre_id)
join movie_actor ma using (movie_id)
join movie m using (movie_id)
join person p on ma.actor_id = p.person_id
where person_name = 'Robert De Niro' and m.release_date >= '2010-01-01'
