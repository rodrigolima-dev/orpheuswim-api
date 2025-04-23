create table users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,

    primary key(id)
);
