-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
select title
from movie m
join collection c on m.collection_id = c.collection_id
join person p on m.director_id = p.person_id
where c.collection_name = 'Star Wars Collection'
and p.person_name != 'George Lucas';

