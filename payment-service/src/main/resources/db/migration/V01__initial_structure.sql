create table payments(
payment_id bigserial primary key,
order_id bigint not null,
payment_amount float not null,
payment_created_at timestamp not null,
payment_updated_at timestamp not null,
payment_status varchar(20) not null
);