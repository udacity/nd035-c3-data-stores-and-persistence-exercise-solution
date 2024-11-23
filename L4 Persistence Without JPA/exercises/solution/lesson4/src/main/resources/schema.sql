CREATE TABLE IF NOT EXISTS candy (
    id BIGINT NOT NULL,
    name VARCHAR(255),
    price DECIMAL(12, 4),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS candy_delivery (
    candy_id BIGINT NOT NULL,
    delivery_id BIGINT NOT NULL
);
