INSERT INTO legislation(ID, NAME, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(1,'legislation',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_legislation RESTART WITH 2;

INSERT INTO autonomous_community(ID, NAME, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(1,'comunidad autonoma',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_autonomous_community RESTART WITH 2;

INSERT INTO profile(ID, NAME, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(1,'profile',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_profile RESTART WITH 2;

INSERT INTO user_type(ID, PROFILE_ID, NAME, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(1,1,'type',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_user_type RESTART WITH 2;

INSERT INTO users(ID, NAME, PASSWORD, EMAIL, CCAA_ID, PROFILE_ID, USER_TYPE_ID, PHONE, FIRST_SURNAME, SECOND_SURNAME, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, ID_STATE)
VALUES(1, 'jhon','admin', 'jhon@correo.com', 1, 1, 1, '123456789','rojas', 'silva', LOCALTIMESTAMP, LOCALTIMESTAMP, 1, 1,1);

ALTER SEQUENCE seq_users RESTART WITH 2;

INSERT INTO campaign_type(ID, TYPE, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(1,'Alimenticia',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_campaign_type RESTART WITH 2;

INSERT INTO campaign_type(ID, TYPE, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(2,'No alimenticia',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_campaign_type RESTART WITH 2;

INSERT INTO campaign_type(ID, TYPE, ID_STATE, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY)
VALUES(3,'Servicios',1,LOCALTIMESTAMP,LOCALTIMESTAMP,1,1);

ALTER SEQUENCE seq_campaign_type RESTART WITH 2;




