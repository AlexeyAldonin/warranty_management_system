create table warranty_management_system.spare_parts
(
    part_number integer not null
        constraint spare_parts_pk
            primary key,
    part_name varchar not null,
    part_price integer default 0 not null
);

comment on table warranty_management_system.spare_parts is 'детали';

alter table warranty_management_system.spare_parts owner to postgres;

create unique index spare_parts_part_number_uindex
    on warranty_management_system.spare_parts (part_number);

