DROP TABLE outfit;
DROP TABLE person;

CREATE TABLE IF NOT EXISTS person (
    id bigint NOT NULL AUTO_INCREMENT,
    age integer,
    favorite_composer varchar(255),
    name varchar(255),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS outfit (
    id bigint NOT NULL AUTO_INCREMENT,
    person_id bigint NOT NULL,
    gloves varchar(255),
    hat varchar(255),
    legs varchar(255),
    shoes varchar(255),
    top varchar(255),
    primary key (id),
    FOREIGN KEY (person_id)
        REFERENCES person(id)
        ON DELETE CASCADE
);