create table orders(
                       order_id bigserial primary key,
                       user_id bigint,
                       order_shipping_status varchar(20),
                       order_payment_status varchar(20),
                       order_amount int,
                       order_currency varchar(10),
                       order_description varchar(256),
                       order_created_at timestamp,
                       order_updated_at timestamp
);

insert into orders (user_id, order_shipping_status, order_payment_status, order_amount, order_currency, order_description, order_created_at, order_updated_at)
values( 1, 'CREATED', 'PAID', 299, 'NOK', 'so much cat food', now(), now() );

insert into orders (user_id, order_shipping_status, order_payment_status, order_amount, order_currency, order_description, order_created_at, order_updated_at)
values( 1, 'CREATED', 'PAID', 54, 'NOK', 'dice', now(), now() );

insert into orders (user_id, order_shipping_status, order_payment_status, order_amount, order_currency, order_description, order_created_at, order_updated_at)
values( 1, 'CREATED', 'PAID', 3424, 'NOK', 'How to train dragons', now(), now() );

insert into orders (user_id, order_shipping_status, order_payment_status, order_amount, order_currency, order_description, order_created_at, order_updated_at)
values( 1, 'CREATED', 'PAID', 3521, 'NOK', 'board games', now(), now() );

insert into orders (user_id, order_shipping_status, order_payment_status, order_amount, order_currency, order_description, order_created_at, order_updated_at)
values( 1, 'CREATED', 'PENDING', 3, 'NOK', 'more cat food', now(), now() );