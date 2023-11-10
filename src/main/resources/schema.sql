CREATE TABLE IF NOT EXISTS car(
    id varchar(255) not null
    primary key,
    brand varchar(255) not null,
    model varchar(255) not null,
    color varchar(255),
    number_of_doors int,
    number_of_seats int
    );