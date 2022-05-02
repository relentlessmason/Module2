-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)

select title, person_name
from movie m
inner join person p on m.director_id = p.person_id
join movie_actor ma using (movie_id)
where m.director_id = ma.actor_id