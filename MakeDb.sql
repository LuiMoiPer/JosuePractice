/* Make the entity tables */
CREATE TABLE item (
    item_id serial PRIMARY KEY,
    name VARCHAR(50),
    price NUMERIC
);

CREATE TABLE receipt (
    receipt_id serial PRIMARY KEY,
    time_stamp TIMESTAMP,
    total NUMERIC
);

CREATE TABLE market (
    market_id serial PRIMARY KEY,
    address VARCHAR,
    zip NUMERIC(5),
    num_customers INTEGER
);

CREATE TABLE customer (
    customer_id serial PRIMARY KEY,
    name VARCHAR,
    sex CHAR(1),
    email VARCHAR NOT NULL UNIQUE,
    phone NUMERIC(10),
    address VARCHAR,
    zip NUMERIC(5),
    card_num NUMERIC(16),
    password VARCHAR NOT NULL
);

/* Make the relation tables */
CREATE TABLE orders (
    customer_id INTEGER,
    receipt_id INTEGER,
    PRIMARY KEY (customer_id, receipt_id),
    CONSTRAINT fk_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk_receipt_id
        FOREIGN KEY (receipt_id) REFERENCES receipt(receipt_id)
);

CREATE TABLE shops_at (
    customer_id INTEGER,
    market_id INTEGER,
    PRIMARY KEY (customer_id, market_id),
    CONSTRAINT fk_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk_market_id
        FOREIGN KEY (market_id) REFERENCES market(market_id)
);

CREATE TABLE records (
    market_id INTEGER,
    receipt_id INTEGER,
    PRIMARY KEY (market_id, receipt_id),
    CONSTRAINT fk_market_id
        FOREIGN KEY (market_id) REFERENCES market(market_id),
    CONSTRAINT fk_receipt_id
        FOREIGN KEY (receipt_id) REFERENCES receipt(receipt_id)
);

CREATE TABLE stores (
    market_id INTEGER,
    item_id INTEGER,
    quantity INTEGER,
    PRIMARY KEY (market_id, item_id),
    CONSTRAINT fk_market_id
        FOREIGN KEY (market_id) REFERENCES market(market_id),
    CONSTRAINT fk_item_id
        FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE items_purchased (
    receipt_id INTEGER,
    item_id INTEGER,
    quantity INTEGER,
    PRIMARY KEY (receipt_id, item_id),
    CONSTRAINT fk_receipt_id
        FOREIGN KEY (receipt_id) REFERENCES receipt(receipt_id),
    CONSTRAINT fk_item_id
        FOREIGN KEY (item_id) REFERENCES item(item_id)
);