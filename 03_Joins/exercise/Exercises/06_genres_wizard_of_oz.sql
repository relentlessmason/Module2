-- 6. The genres of "The Wizard of Oz" (3 rows)
select genre_name
from genre g
join movie_genre mg on mg.genre_id = g.genre_id
join movie m on mg.movie_id = m.movie_id
where title = 'The Wizard of Oz'

