-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)

select title, tagline
from movie
join movie_genre mg using (movie_id)
join genre g using (genre_id)
join movie_actor ma using (movie_id)
join person p on ma.actor_id = p.person_id
where genre_name = 'Family' and person_name = 'Samuel L. Jackson'


