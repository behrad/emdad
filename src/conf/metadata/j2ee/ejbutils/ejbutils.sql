CREATE TABLE HIGH_KEY
(
  NAME CHAR(25) NOT NULL,
  VALUE CHAR(28) NOT NULL
);

CREATE UNIQUE INDEX PK_HIGH_KEY ON HIGH_KEY(NAME);


CREATE TABLE users(username VARCHAR(64) PRIMARY KEY, password VARCHAR(64));
CREATE TABLE userRoles(username VARCHAR(64), role VARCHAR(32), roleGroup VARCHAR(32) );

INSERT INTO users VALUES('admin', 'admin');
INSERT INTO userRoles VALUES('admin', 'admin', 'Roles');
INSERT INTO users VALUES('s', 's');
INSERT INTO userRoles VALUES('s', 'student', 'Roles');
