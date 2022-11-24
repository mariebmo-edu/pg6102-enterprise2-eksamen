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

insert into orders
values(nextval('orders_order_id_seq'), 1, 'CREATED', 'PAID', 299, 'NOK', 'so much cat food', now(), now() );

insert into orders
values(nextval('orders_order_id_seq'), 1, 'CREATED', 'PAID', 54, 'NOK', 'dice', now(), now() );

insert into orders
values(nextval('orders_order_id_seq'), 1, 'CREATED', 'PAID', 3424, 'NOK', 'How to train dragons', now(), now() );

insert into orders
values(nextval('orders_order_id_seq'), 1, 'CREATED', 'PAID', 3521, 'NOK', 'board games', now(), now() );

insert into orders
values(nextval('orders_order_id_seq'), 1, 'CREATED', 'PENDING', 3, 'NOK', 'more cat food', now(), now() );