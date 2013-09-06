# --- !Ups
CREATE TABLE kamoku (
  kamoku_id INT AUTO_INCREMENT PRIMARY KEY,
  kamoku_mei VARCHAR(255) NOT NULL
);
CREATE TABLE kyokasyo (
  kyokasyo_id INT AUTO_INCREMENT PRIMARY KEY,
  kyokasyo_mei VARCHAR(255) NOT NULL,
  han_no INT NOT NULL,
  kamoku_id INT NOT NULL
);
CREATE TABLE sho (
  kyokasyo_id INT NOT NULL,
  sho_mei VARCHAR(255) NOT NULL,
  page INT NOT NULL
);
CREATE TABLE tangen (
  kyokasyo_id INT NOT NULL,
  tangen_mei VARCHAR(255) NOT NULL,
  page INT NOT NULL
);
CREATE TABLE contents (
  kyokasyo_id INT NOT NULL,
  page INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  point VARCHAR(255) NOT NULL,
  tags VARCHAR(255) NOT NULL
);
# --- !Downs
DROP TABLE kamoku;
DROP TABLE kyokasyo;
DROP TABLE sho;
DROP TABLE tangen;
DROP TABLE contents;