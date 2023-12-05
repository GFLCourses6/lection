CREATE DATABASE encyclopedia
    WITH
    OWNER = pg
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE birds
(
    id          SERIAL PRIMARY KEY,
    bird        VARCHAR(256) UNIQUE NOT NULL,
    description VARCHAR(1024)
);

ALTER TABLE IF EXISTS public.birds OWNER TO pg;

INSERT INTO birds (bird, description)
VALUES ('pigeon', 'Common city bird with gray feathers'),
       ('eagle', 'Large bird of prey with strong beak and talons'),
       ('rooster', 'Male chicken known for its crowing at dawn'),
       ('sparrow', 'Small bird with brown and gray plumage'),
       ('owl', 'Nocturnal bird of prey with distinctive hooting sound');
