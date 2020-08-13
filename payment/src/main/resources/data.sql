DROP TABLE IF EXISTS payment CASCADE;

CREATE TABLE payment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  card_id INT NOT NULL,
  description VARCHAR(250) NOT NULL,
  value DECIMAL NOT NULL
);

INSERT INTO payment (card_id, description, value) VALUES
  (1, 'cerveja', 50.05),
  (1, 'picanha', 92.00),
  (2, 'pão de alho', 33.50);
