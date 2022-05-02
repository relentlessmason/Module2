-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.

select distinct genre_name from genre g
join movie_genre mg on g.genre_id = mg.genre_id
join movie_actor ma using (movie_id)
join person p on ma.actor_id = p.person_id
where person_name = 'Christopher Lloyd'