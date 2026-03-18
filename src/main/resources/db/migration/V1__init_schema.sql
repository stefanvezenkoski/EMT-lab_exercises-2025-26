CREATE TABLE country (
                         id        BIGSERIAL PRIMARY KEY,
                         name      VARCHAR(100) NOT NULL,
                         continent VARCHAR(100) NOT NULL
);

CREATE TABLE host (
                      id         BIGSERIAL PRIMARY KEY,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      name       VARCHAR(100) NOT NULL,
                      surname    VARCHAR(100) NOT NULL,
                      country_id BIGINT REFERENCES country(id)
);

CREATE TABLE accommodation (
                               id         BIGSERIAL PRIMARY KEY,
                               created_at TIMESTAMP,
                               updated_at TIMESTAMP,
                               name       VARCHAR(200) NOT NULL,
                               category   VARCHAR(50)  NOT NULL,
                               condition  VARCHAR(50)  NOT NULL DEFAULT 'GOOD',
                               num_rooms  INTEGER      NOT NULL,
                               host_id    BIGINT REFERENCES host(id),
                               rented     BOOLEAN      NOT NULL DEFAULT FALSE
);