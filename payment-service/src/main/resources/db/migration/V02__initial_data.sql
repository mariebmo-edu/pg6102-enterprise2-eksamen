create table payments(
                         payment_id bigserial primary key,
                         order_id bigint not null,
                         payment_amount float not null,
                         payment_created_at timestamp not null,
                         payment_updated_at timestamp not null,
                         payment_status varchar(20) not null
);

insert into payments
values (nextval('payments_payment_id_seq'), 1, 299, now(), now(), 'PAID');

insert into payments
values (nextval('payments_payment_id_seq'), 2, 54, now(), now(), 'PAID');

insert into payments
values (nextval('payments_payment_id_seq'), 3, 3424, now(), now(), 'PAID');

insert into payments
values (nextval('payments_payment_id_seq'), 4, 3521, now(), now(), 'PAID');

insert into payments
values (nextval('payments_payment_id_seq'), 5, 3, now(), now(), 'PENDING');