-- Hibernate 6+ uses one sequence per entity (<entity>_seq) with an allocation size of 50
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE orders_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE payment_seq START WITH 1 INCREMENT BY 50;
