-- 4. The titles and taglines of all the movies that are in the Fantasy genre. Order the results by title (A-Z) (81 rows)
select title, tagline from movie
join movie_genre using (movie_id)
join genre using (genre_id)
where genre_name = 'Fantasy'
order by title;
