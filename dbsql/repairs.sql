create table warranty_management_system.repairs
(
	claim_number serial not null
		constraint repairs_pk
			primary key,
	vehicle_vin varchar not null
		constraint repairs_vehicles_vin_fk
			references warranty_management_system.vehicles,
	vehicle_mileage integer not null,
	repair_date date not null,
	part_number integer not null,
	part_name varchar not null,
	part_quantity integer default 0 not null,
	parts_cost double precision default 0 not null,
	repair_operation_id integer not null,
	repair_operation_name varchar not null,
	repair_hours double precision default 0 not null,
	repair_operations_cost double precision default 0 not null,
	repair_total_cost double precision default 0 not null
);

comment on table warranty_management_system.repairs is 'реестр выполненных ремонтов';

alter table warranty_management_system.repairs owner to postgres;

create unique index repairs_claim_number_uindex
	on warranty_management_system.repairs (claim_number);

