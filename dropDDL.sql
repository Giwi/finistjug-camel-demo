ALTER TABLE PARTICIPANT DROP FOREIGN KEY FK_PARTICIPANT_pres_id
DROP TABLE PARTICIPANT
DROP TABLE JUGPRESENTATION
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
