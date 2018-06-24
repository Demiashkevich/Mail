CREATE TABLE application
(
  application_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  description VARCHAR,
  created_at DATE,
  expiration_at DATE,
  status VARCHAR
);
