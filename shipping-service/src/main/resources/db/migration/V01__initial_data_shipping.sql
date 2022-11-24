create table shipments (
                          shipment_id bigserial primary key,
                          order_id bigint,
                          shipment_created_at timestamp,
                          shipment_updated_at timestamp,
                          shipment_status varchar(255)
);

insert into shipments (order_id, shipment_created_at, shipment_updated_at, shipment_status)
values (1, now(), now(), 'SHIPPED');

insert into shipments (order_id, shipment_created_at, shipment_updated_at, shipment_status)
values (2, now(), now(), 'SHIPPED');

insert into shipments (order_id, shipment_created_at, shipment_updated_at, shipment_status)
values (3, now(), now(), 'SHIPPED');

insert into shipments (order_id, shipment_created_at, shipment_updated_at, shipment_status)
values (4, now(), now(), 'SHIPPED');
