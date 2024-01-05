DROP TABLE IF EXISTS client_roles CASCADE;
DROP TABLE IF EXISTS client_authority CASCADE;
DROP TABLE IF EXISTS authority CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS client CASCADE;

CREATE TABLE IF NOT EXISTS client
(
    client_id bigint PRIMARY KEY,
    name      varchar(255) NOT NULL,
    password  varchar(255) NOT NULL,
    age       integer      NOT NULL,
    role_id   bigint
);

CREATE TABLE IF NOT EXISTS authority
(
    authority_id bigint PRIMARY KEY,
    name         varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    role_id      bigint PRIMARY KEY,
    type         varchar(255) NOT NULL,
    authority_id bigint,
    client_id    bigint,
    FOREIGN KEY (client_id) REFERENCES client (client_id)
);

ALTER TABLE role
    ADD FOREIGN KEY (authority_id) REFERENCES authority (authority_id);

ALTER TABLE client
    ADD FOREIGN KEY (role_id) REFERENCES role (role_id);

CREATE TABLE IF NOT EXISTS client_authority
(
    client_id    bigint,
    authority_id bigint,
    PRIMARY KEY (client_id, authority_id),
    FOREIGN KEY (client_id) REFERENCES client (client_id),
    FOREIGN KEY (authority_id) REFERENCES authority (authority_id)
);

CREATE TABLE IF NOT EXISTS client_roles
(
    client_id bigint,
    role_id   bigint,
    PRIMARY KEY (client_id, role_id),
    FOREIGN KEY (client_id) REFERENCES client (client_id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

INSERT INTO authority (authority_id, name)
VALUES (1, 'READ_PRIVILEGE'),
       (2, 'WRITE_PRIVILEGE');

INSERT INTO client (client_id, name, password, age)
VALUES (1, 'Alice', 'alice', 25),
       (2, 'Bob', 'bob', 30);

INSERT INTO role (role_id, type, authority_id, client_id)
VALUES (1, 'ADMIN', 1, 1),
       (2, 'USER', 2, 2);
