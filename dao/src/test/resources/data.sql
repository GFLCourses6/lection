CREATE TABLE IF NOT EXISTS BIRDS (
                                     id          SERIAL PRIMARY KEY,
                                     bird  VARCHAR(256) UNIQUE NOT NULL,
                                     description VARCHAR(1024)
);

INSERT INTO birds (bird, description)
VALUES ('sparrow', 'Small bird with brown and gray plumage'),
       ('eagle', 'Large bird of prey with strong beak and talons');

DELETE FROM BIRDS WHERE BIRD IN (SELECT BIRD FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'BIRDS');
