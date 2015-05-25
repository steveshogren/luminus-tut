CREATE TABLE guestbook
(id  serial primary key,
 name VARCHAR(30),
 message VARCHAR(200),
 timestamp TIMESTAMP);
