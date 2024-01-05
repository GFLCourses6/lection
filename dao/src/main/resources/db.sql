CREATE DATABASE encyclopedia
    WITH
    OWNER = pg
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE birdRecords
(
    id          SERIAL PRIMARY KEY,
    birdRecord        VARCHAR(256) UNIQUE NOT NULL,
    description VARCHAR(1024)
);

ALTER TABLE IF EXISTS public.birdRecords OWNER TO pg;

INSERT INTO birdRecords (birdRecord, description)
VALUES ('pigeon', 'Common city birdRecord with gray feathers'),
       ('eagle', 'Large birdRecord of prey with strong beak and talons'),
       ('rooster', 'Male chicken known for its crowing at dawn'),
       ('sparrow', 'Small birdRecord with brown and gray plumage'),
       ('owl', 'Nocturnal birdRecord of prey with distinctive hooting sound');
