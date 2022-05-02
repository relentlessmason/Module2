-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)

select title, release_date
from person p
join movie_actor on actor_id = person_id
join movie on movie_actor.movie_id = movie.movie_id
where person_name = 'Tom Hanks'