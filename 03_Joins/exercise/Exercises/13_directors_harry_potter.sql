-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)

select distinct person_name
from person p
join movie m on person_id = director_id
join collection using (collection_id)
where collection_name = 'Harry Potter Collection'
