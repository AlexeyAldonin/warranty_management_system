create table warranty_management_system.vehicles
(
    vin varchar not null
        constraint vehicles_pk
            primary key,
    model varchar not null,
    dispatch_date date not null,
    date_of_sale date,
    warranty_expire_date date,
    mileage_at_last_claim integer
);

comment on table warranty_management_system.vehicles is 'все автомобили';

alter table warranty_management_system.vehicles owner to postgres;

create unique index vehicles_vin_uindex
    on warranty_management_system.vehicles (vin);

