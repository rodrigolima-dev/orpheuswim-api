create table products(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(19, 2) NOT NULL,
    image_url VARCHAR(512),
    category VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,

    primary key(id)
);
