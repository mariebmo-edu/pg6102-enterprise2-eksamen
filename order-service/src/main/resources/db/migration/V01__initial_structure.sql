create table orders(
order_id bigserial primary key,
user_id bigint not null,
order_shipping_status varchar(20) not null,
order_payment_status varchar(20) not null,
order_amount int not null,
order_currency varchar(10) not null,
order_description varchar(256),
order_created_at timestamp not null,
order_updated_at timestamp not null
);