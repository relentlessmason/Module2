-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

insert into person (person_name, birthday, biography, home_page)
values ('Amber Mason Stinchcomb-Bildstein', '1991-03-29', 'A soon-to-graduate software developer with a passion for art and apparently, the desire to direct a movie about thier origin story.', 'https://www.linkedin.com/in/amber-stinchcomb-891371124/');

update movie
set director_id = (select person_id from person where person_name = 'Amber Mason Stinchcomb-Bildstein')
where title = 'The Blob';