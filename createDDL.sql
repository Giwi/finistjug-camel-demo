CREATE TABLE PARTICIPANT (ID INTEGER NOT NULL, EMAIL VARCHAR(255), FORNAME VARCHAR(255), NAME VARCHAR(255), pres_id INTEGER, PRIMARY KEY (ID))
CREATE TABLE JUGPRESENTATION (ID INTEGER NOT NULL, DESCRIPTION LONGTEXT, PRESENTATIONDATE DATETIME, TITLE VARCHAR(255), URL VARCHAR(255), PRIMARY KEY (ID))
ALTER TABLE PARTICIPANT ADD CONSTRAINT FK_PARTICIPANT_pres_id FOREIGN KEY (pres_id) REFERENCES JUGPRESENTATION (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
