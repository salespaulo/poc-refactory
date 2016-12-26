CREATE TABLE service_travel (
    id            SERIAL 	   PRIMARY KEY,
    name          VARCHAR(100) NOT NULL
);

ALTER TABLE service_travel OWNER TO poc;

CREATE TABLE seat (
	id      INT          PRIMARY KEY,
	tp_seat VARCHAR(100) NOT NULL
);

ALTER TABLE seat OWNER TO poc;

CREATE TABLE ticket_booking (
	id                SERIAL         PRIMARY KEY,
	serv_trav_id      INT            NOT NULL REFERENCES service_travel (id),
	tp_ticket         VARCHAR(100)   NOT NULL, 
	seat_id           INT            NOT NULL REFERENCES seat (id),
  	customer_name     VARCHAR(100)   NULL,
	dt_departure      DATE           NOT NULL,
	tm_departure      TIME           NOT NULL,
    price_base        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	price_toll        NUMERIC(10, 2) NULL,
  	price_tax         NUMERIC(10, 2) NULL,
  	price_board_tax   NUMERIC(10, 2) NULL,
  	price_discount    NUMERIC(10, 2) NULL,
  	price_insurance   NUMERIC(10, 2) NULL,
  	price_other_taxes NUMERIC(10, 2) NULL
);

ALTER TABLE ticket_booking OWNER TO poc;

CREATE TABLE price (
	id          INT            PRIMARY KEY,
	base        NUMERIC(10, 2) NOT NULL DEFAULT 0,
  	toll        NUMERIC(10, 2) NULL,
  	tax         NUMERIC(10, 2) NULL, 
  	board_tax   NUMERIC(10, 2) NULL,
  	discount    NUMERIC(10, 2) NULL,
  	insurance   NUMERIC(10, 2) NULL,
  	other_taxes NUMERIC(10, 2) NULL
);

ALTER TABLE price OWNER TO poc;

CREATE TABLE pricing (
	id           SERIAL       PRIMARY KEY,
	name         VARCHAR(100) NOT NULL,
	serv_trav_id INT          NOT NULL REFERENCES service_travel (id),
	tp_ticket    VARCHAR(100) NOT NULL,
	tp_seat      VARCHAR(100) NOT NULL,
	price_id     INT REFERENCES price (id)
);

ALTER TABLE pricing OWNER TO poc;

