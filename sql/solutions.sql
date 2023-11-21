-- 1. Display the filmography of a given actor/actress.
SELECT * FROM movies as m
                  JOIN movie_cast as mc ON m.id = mc.movie_id
                  JOIN casts as c on mc.cast_id = c.id
WHERE c.name='Brad Pitt';

-- 2. Display the cast of a given film
SELECT * FROM casts as c
                  JOIN movie_cast as mc ON c.id = mc.cast_id
                  JOIN movies as m ON mc.movie_id = m.id
WHERE m.name='Avengers';

-- 3. Display films released between two given years.
SELECT * FROM movies as m WHERE m.year BETWEEN 2010 AND 2011;

-- 4. Display films common to two given actors/actresses.
SELECT * FROM movies as m
                  JOIN movie_cast as mc1
                       ON m.id = mc1.movie_id
                  JOIN movie_cast as mc2
                       ON m.id = mc2.movie_id
                  JOIN casts as c1
                       ON mc1.cast_id = c1.id
                  JOIN casts as c2
                       ON mc2.cast_id = c2.id
WHERE c1.name='Chris Evans'
  AND c2.name='Robert Downey Jr.';

-- 5. Display actors common to two given films.
SELECT * FROM casts as c
                  JOIN movie_cast as mc1 ON c.id = mc1.cast_id
                  JOIN movie_cast as mc2 ON c.id = mc2.cast_id
                  JOIN movies as m1 ON  mc1.movie_id = m1.id
                  JOIN movies as m2 ON m2.id = mc2.movie_id
WHERE m1.name='Avengers'
  AND m2.name='Captain America: Civil War';

-- 6. Display films released between two given years that feature a given actor/actress in the cast.
SELECT * FROM movies as m
                  JOIN movie_cast as mc ON m.id = mc.movie_id
                  JOIN casts as c on mc.cast_id = c.id
WHERE m.year BETWEEN 2010 AND 2011
  AND c.name='Leonardo DiCaprio';

