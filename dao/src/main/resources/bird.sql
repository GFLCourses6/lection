CREATE TABLE birds
(
    id          SERIAL PRIMARY KEY,
    bird  VARCHAR(256) UNIQUE NOT NULL,
    description VARCHAR(1024)
);

INSERT INTO birds (bird, description)
VALUES ('pigeon', 'Common city birdRecord with gray feathers'),
       ('eagle', 'Large birdRecord of prey with strong beak and talons'),
       ('rooster', 'Male chicken known for its crowing at dawn'),
       ('sparrow', 'Small birdRecord with brown and gray plumage'),
       ('owl', 'Nocturnal birdRecord of prey with distinctive hooting sound');
