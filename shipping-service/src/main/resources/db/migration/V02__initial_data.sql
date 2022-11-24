create table shipments(
                          shipment_id bigserial primary key,
                          order_id bigint not null,
                          shipment_created_at timestamp not null,
                          shipment_updated_at timestamp not null,
                          shipment_status varchar(255) not null
);

insert into shipments
values (nextval('shipments_shipment_id_seq'), 1, now(), now(), 'SHIPPED');

insert into shipments
values (nextval('shipments_shipment_id_seq'), 2, now(), now(), 'SHIPPED');

insert into shipments
values (nextval('shipments_shipment_id_seq'), 3, now(), now(), 'SHIPPED');

insert into shipments
values (nextval('shipments_shipment_id_seq'), 4, now(), now(), 'SHIPPED');
