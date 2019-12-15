INSERT INTO role(
	id, role)
	VALUES ('1', 'user');

INSERT INTO role(
	id, role)
	VALUES ('2', 'admin');

INSERT INTO users(
    id, enabled, name, password, surname, username, role_id)
VALUES ('3', 'true', 'ADMIN', '$2a$08$4CRQ86couIxoIn8qX3him.cagkdvIjuCsvIXpJQxIMiKRj5j3vaBW', '', 'admin', '2');