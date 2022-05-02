-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

update movie set collection_id = (select collection_id from collection where collection_name = 'Bill Murray Collection')
where movie_id in (select movie_id from movie_actor ma join person p on ma.actor_id = p.person_id where person_name = 'Bill Murray')
