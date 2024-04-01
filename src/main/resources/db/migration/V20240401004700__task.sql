CREATE TABLE users (
        id BIGSERIAL PRIMARY KEY,
        login text NOT NULL,
        password TEXT NOT NULL);