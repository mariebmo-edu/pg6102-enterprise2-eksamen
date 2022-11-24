create table payments(
                         payment_id bigserial primary key,
                         order_id bigint,
                         payment_amount float,
                         payment_created_at timestamp,
                         payment_updated_at timestamp,
                         payment_status varchar(20)
);

insert into payments (order_id, payment_amount, payment_created_at, payment_updated_at, payment_status)
values (1, 299, now(), now(), 'PAID');

insert into payments (order_id, payment_amount, payment_created_at, payment_updated_at, payment_status)
values (2, 54, now(), now(), 'PAID');

insert into payments (order_id, payment_amount, payment_created_at, payment_updated_at, payment_status)
values (3, 3424, now(), now(), 'PAID');

insert into payments (order_id, payment_amount, payment_created_at, payment_updated_at, payment_status)
values (4, 3521, now(), now(), 'PAID');

insert into payments (order_id, payment_amount, payment_created_at, payment_updated_at, payment_status)
values (5, 3, now(), now(), 'PENDING');