CREATE TABLE IF NOT EXISTS car(
    id varchar(255) not null
    primary key,
    brand varchar(255) not null,
    model varchar(255) not null,
    color varchar(255),
    number_of_doors int,
    number_of_seats int
    );

CREATE TABLE IF NOT EXISTS license_plate(
    id varchar(255) not null
    primary key,
    license_plate_number varchar(255) not null,
    country varchar(255) not null
);

ALTER TABLE car ADD COLUMN IF NOT EXISTS license_plate_id varchar(255) constraint FK_region_id
    references license_plate;