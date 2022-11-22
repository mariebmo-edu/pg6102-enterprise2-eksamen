/*Create databases*/
CREATE DATABASE orderdb;
CREATE DATABASE paymentdb;
CREATE DATABASE shippingdb;

CREATE TABLE orderdb.users(
    user_id bigserial primary key,
    user_email varchar(150),
    user_password varchar(255),
    user_created timestamp,
    user_enabled bool
);

CREATE TABLE orderdb.items(
    item_id bigserial primary key,
    item_name varchar(255),
    item_price bigserial,
    item_created timestamp
);

/*Add some init content*/
CREATE TABLE orderdb.orders(
    order_id bigserial primary key,
    order_total bigserial,
    order_created timestamp
);