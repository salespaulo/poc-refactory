INSERT INTO service_travel (name) VALUES
	('SP-AT');

INSERT INTO service_travel (name) VALUES
	('SP-SJC');

INSERT INTO service_travel (name) VALUES
	('SP-RJ');

INSERT INTO seat (id, tp_seat) VALUES
	(10, 'CONVENCIONAL');

INSERT INTO seat (id, tp_seat) VALUES
	(20, 'SEMI-LEITO');

INSERT INTO seat (id, tp_seat) VALUES
	(30, 'LEITO');

-- Saindo as 10:00
INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'NORMAL', 10, 'TESTE NORMAL 10', '2017-01-10', '10:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'ESTUDANTE', 20, 'TESTE ESTUDANTE 20', '2017-01-10', '10:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'IDOSO', 30, 'TESTE IDOSO 30', '2017-01-10', '10:00');

-- Saindo as 15:00
INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'ESTUDANTE', 10, 'TESTE ESTUDANTE 10', '2017-01-10', '15:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'NORMAL', 20, 'TESTE NORMAL 20', '2017-01-10', '15:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'IDOSO', 30, 'TESTE IDOSO 30', '2017-01-10', '15:00');

-- Saindo as 17:00
INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'ESTUDANTE', 30, 'TESTE ESTUDANTE 30', '2017-01-10', '17:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'ESTUDANTE', 30, 'TESTE ESTUDANTE 30', '2017-01-10', '17:00');

-- Saindo as 19:00
INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'IDOSO', 10, 'TESTE NORMAL 30', '2017-01-10', '17:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'ESTUDANTE', 20, 'TESTE NORMAL 30', '2017-01-10', '17:00');

INSERT INTO ticket_booking (serv_trav_id, tp_ticket, seat_id, customer_name, dt_departure, tm_departure)
	VALUES (1, 'NORMAL', 30, 'TESTE NORMAL 30', '2017-01-10', '17:00');


INSERT INTO price(id, base, toll, tax, board_tax, discount, insurance, other_taxes)
	VALUES(1, 100.0, 10.0, 1.0, 2.0, 0.0, 3.0, 0.0);

INSERT INTO price(id, base, toll, tax, board_tax, discount, insurance, other_taxes)
	VALUES(2, 200.0, 20.0, 2.0, 4.0, 6.0, 2.0, 3.0);

INSERT INTO price(id, base, toll, tax, board_tax, discount, insurance, other_taxes)
	VALUES(3, 300.0, 10.0, 10.0, 2.0, 0.0, 3.0, 0.0);

INSERT INTO price(id, base, toll, tax, board_tax, discount, insurance, other_taxes)
	VALUES(4, 400.0, 10.0, 1.0, 2.0, 0.0, 0.0, 10.0);

INSERT INTO price(id, base, toll, tax, board_tax, discount, insurance, other_taxes)
	VALUES(5, 100.0, 0.0, 1.0, 0.0, 100.0, 0.0, 0.0);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=NORMAL SEAT=CONVENCIONAL PRICE=1', 1, 'NORMAL', 'CONVENCIONAL', 1);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=NORMAL SEAT=CONVENCIONAL PRICE=1', 1, 'NORMAL', 'SEMI-LEITO', 2);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=NORMAL SEAT=CONVENCIONAL PRICE=1', 1, 'NORMAL', 'LEITO', 4);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=CONVENCIONAL PRICE=1', 1, 'ESTUDANTE', 'CONVENCIONAL', 2);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=SEMI-LEITO PRICE=1', 1, 'ESTUDANTE', 'SEMI-LEITO', 3);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=LEITO PRICE=1', 1, 'ESTUDANTE', 'LEITO', 4);
	
INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=CONVENCIONAL PRICE=1', 1, 'IDOSO', 'CONVENCIONAL', 5);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=SEMI-LEITO PRICE=1', 1, 'IDOSO', 'SEMI-LEITO', 2);

INSERT INTO pricing(name, serv_trav_id, tp_ticket, tp_seat, price_id)
	VALUES('PRICE SERV=1 TICKET=ESTUDANTE SEAT=LEITO PRICE=1', 1, 'IDOSO', 'LEITO', 3);
	
