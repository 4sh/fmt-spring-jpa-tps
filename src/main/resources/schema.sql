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

CREATE TABLE IF NOT EXISTS technical_control(
    id varchar(255) not null
        primary key,
    garage varchar(255) not null,
    control_year varchar(255) not null,
    technical_controller varchar(255) not null,
    car_id varchar(255) constraint FK_car_id
        references car
);

CREATE TABLE IF NOT EXISTS driver(
    id varchar(255) not null
    primary key,
    name varchar(255) not null
);

CREATE TABLE IF NOT EXISTS car_driver
(
    car_id varchar(255) not null
        CONSTRAINT FK_cars_drivers_car_id
            REFERENCES car,
    driver_id varchar(255) not null
        CONSTRAINT FK_cars_drivers_driver_id
            REFERENCES driver
);

CREATE TABLE IF NOT EXISTS vehicle
(
    id varchar(255) not null
        primary key,
    brand varchar(255) not null,
    registration varchar(255),
    tonnage int,
    vehicle_class varchar(255)
);

ALTER TABLE vehicle
    DROP COLUMN IF EXISTS registration;

ALTER TABLE vehicle
    DROP COLUMN IF EXISTS tonnage;

CREATE TABLE IF NOT EXISTS truck
(
    id varchar(255) not null
        primary key,
    tonnage int,
    constraint FK_truck_vehicle_id foreign key (id) references vehicle
);

CREATE TABLE IF NOT EXISTS trailer
(
    id varchar(255) not null
        primary key,
    registration varchar(255),
    constraint FK_trailer_vehicle_id foreign key (id) references vehicle
);

ALTER TABLE trailer
    DROP CONSTRAINT IF EXISTS FK_trailer_vehicle_id;

ALTER TABLE truck
    DROP CONSTRAINT IF EXISTS FK_truck_vehicle_id;

ALTER TABLE trailer
    ADD COLUMN IF NOT EXISTS brand VARCHAR(255);

ALTER TABLE truck
    ADD COLUMN IF NOT EXISTS brand VARCHAR(255);

DROP TABLE IF EXISTS vehicle;