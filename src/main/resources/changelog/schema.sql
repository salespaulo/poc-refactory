CREATE TABLE service_travel (
    id            SERIAL 	   PRIMARY KEY,
    name          VARCHAR(100) NOT NULL
);

CREATE TABLE seat (
	id      INT          PRIMARY KEY,
	tp_seat VARCHAR(100) NOT NULL
);

CREATE TABLE ticket_booking (
	id                SERIAL      PRIMARY KEY,
	serv_trav_id      INT            NOT NULL REFERENCES service_travel (id),
	tp_ticket         VARCHAR(100)   NOT NULL, 
	seat_id           INT            NOT NULL REFERENCES seat (id),
  	customer_name     VARCHAR(100)   NULL,
	dt_departure      DATE           NOT NULL,
	tm_departure      TIME           NOT NULL,
    price_base        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_toll        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_tax         NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_board_tax   NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_discount    NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_insurance   NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_other_taxes NUMERIC(10, 2) NOT NULL DEFAULT 0
);

CREATE TABLE price (
	id          INT            PRIMARY KEY,
	base        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	toll        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	tax         NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	board_tax   NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	discount    NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	insurance   NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	other_taxes NUMERIC(10, 2) NOT NULL DEFAULT 0
);

CREATE TABLE pricing (
	id           PRIMARY KEY,
	name         VARCHAR(100) NOT NULL,
	serv_trav_id INT          NOT NULL REFERENCES service_travel (id),
	tp_ticket    VARCHAR(100) NOT NULL,
	tp_seat      VARCHAR(100) NOT NULL,
	price_id     INT REFERENCES price (id)
);

