create table shipments(
    shipment_id bigserial primary key,
    order_id bigint not null,
    shipment_created_at timestamp not null,
    shipment_updated_at timestamp not null,
    shipment_status varchar(255) not null
);