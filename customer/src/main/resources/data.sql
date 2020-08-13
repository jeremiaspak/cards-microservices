DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(150) NOT NULL
);

INSERT INTO customer (name) VALUES
  ('João'),
  ('Maria');
