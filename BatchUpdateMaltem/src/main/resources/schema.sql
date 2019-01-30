drop table if exists message
CREATE TABLE message (
  NAME varchar(45) DEFAULT NULL,
  GIT varchar(45) DEFAULT NULL,
  TIMESTAMP bigint DEFAULT NULL,
  ID bigint NOT NULL,
  PRIMARY KEY (ID)
) ;