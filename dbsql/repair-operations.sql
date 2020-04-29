create table warranty_management_system.repair_operations
(
	operation_id integer not null
		constraint repair_operations_pk
			primary key,
	operation_name varchar not null,
	price integer default 0 not null
);

alter table warranty_management_system.repair_operations owner to postgres;

create unique index repair_operations_operation_id_uindex
	on warranty_management_system.repair_operations (operation_id);

