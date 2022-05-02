-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
select person_name, birthday
from person p
join movie_actor on actor_id = person_id
join movie on movie.movie_id = movie_actor.movie_id
where title = 'The Fifth Element'

