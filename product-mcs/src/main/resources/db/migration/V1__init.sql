CREATE TABLE categories
(	id			serial,
	name		VARCHAR(64) NOT NULL UNIQUE,
	created_at	TIMESTAMP DEFAULT current_timestamp,
	updated_at	TIMESTAMP DEFAULT current_timestamp,
	PRIMARY KEY (id)
);
INSERT INTO categories (name) VALUES	('A'),	('B'),	('C'),	('D');
-- ----------------------------------------------------------------------
CREATE TABLE products
(	id			bigserial,
	title		VARCHAR(255)	NOT NULL,
	price		DECIMAL(10,2),
	rest		INT,
	category_id	INT				NOT NULL,
	created_at	TIMESTAMP DEFAULT current_timestamp,
	updated_at	TIMESTAMP DEFAULT current_timestamp,
	PRIMARY KEY (id),
	FOREIGN KEY (category_id) REFERENCES categories (id)
);
INSERT INTO products (title, price, rest, category_id) VALUES
	('Товар№01',  10.0, 20, 1),	('Товар№02',  20.0, 20, 2),	('Товар№03',  30.0, 20, 3),
	('Товар№04',  40.0, 20, 1),	('Товар№05',  50.0, 20, 3),	('Товар№06',  60.0, 20, 4),
	('Товар№07',  70.0, 20, 4),	('Товар№08',  80.0, 20, 2),	('Товар№09',  90.0, 20, 3);
-- ----------------------------------------------------------------------

