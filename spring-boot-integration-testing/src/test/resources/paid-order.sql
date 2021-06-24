INSERT INTO orders (id, date, amount, paid)
VALUES (1, CURRENT_DATE, 100.0, TRUE);
INSERT INTO payment (id, order_id, credit_card_number)
VALUES (1, 1, '4532756279624064');
