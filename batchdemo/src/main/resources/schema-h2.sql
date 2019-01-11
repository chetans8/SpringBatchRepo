DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
  userid         BIGINT(10)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(255) NOT NULL,
  dept      VARCHAR(255) NOT NULL,
  amount        BIGINT(10)
);