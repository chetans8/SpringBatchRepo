DROP TABLE IF EXISTS PROVIDER;

CREATE TABLE PROVIDER (
  id         BIGINT(10)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name      VARCHAR(255) NOT NULL,
  last_name      VARCHAR(255) NOT NULL,
  email      VARCHAR(255) NOT NULL,
  provider_id        INT(3)       NOT NULL
);