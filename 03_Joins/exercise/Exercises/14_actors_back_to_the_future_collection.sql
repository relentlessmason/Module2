-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)

select distinct person_name
from person p
join movie_actor ma on person_id = ma.actor_id
join movie m on ma.movie_id = m.movie_id
join collection using (collection_id)
where collection_name = 'Back to the Future Collection'