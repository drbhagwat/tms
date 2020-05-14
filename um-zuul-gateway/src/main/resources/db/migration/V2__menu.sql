CREATE TABLE IF NOT EXISTS MENU ( ID SERIAL PRIMARY KEY, NAME VARCHAR(255), COMPONENT_NAME VARCHAR(255),
		                          GROUPS_ID BIGINT, PATH VARCHAR(255), MENUS_ID BIGINT, PARENT_MENU VARCHAR(255),
		                          FOREIGN KEY (GROUPS_ID) REFERENCES GROUPS (ID),
		                          FOREIGN KEY (MENUS_ID) REFERENCES MENU (ID) );

INSERT INTO MENU ( NAME, COMPONENT_NAME, GROUPS_ID ) VALUES ( 'MASTER TABLES', 'CORE API', 1 ),
                                                            ( 'API HISTORY LOG', 'LOGS', 1 );

INSERT INTO MENU ( NAME, COMPONENT_NAME, MENUS_ID, GROUPS_ID, PATH, PARENT_MENU )
            VALUES ( 'COMPANY', 'CORE API', 1, 1, '/company', 'MASTER TABLES' ),
                   ( 'DIVISION', 'CORE API', 1, 1, '/division', 'MASTER TABLES'),
                   ( 'WAREHOUSE', 'CORE API', 1, 1, '/warehouse', 'MASTER TABLES'),
                   ( 'CARRIER SERVICE CODE', 'CORE API', 1, 1, '/carrierServiceCode', 'MASTER TABLES'),
                   ( 'CARRIER PACKAGE CODE', 'CORE API', 1, 1, '/carrierPackageCode', 'MASTER TABLES'),
                   ( 'SHIPMENT REQUEST', 'CORE API', 1, 1, '/shipmentRequest', 'MASTER TABLES');

INSERT INTO MENU ( NAME, COMPONENT_NAME, MENUS_ID, GROUPS_ID, PATH, PARENT_MENU )
            VALUES ( 'PARCEL REQUEST', 'LOGS', 2, 1, '/parcelRequest', 'API HISTORY LOG'),
                   ( 'PARCEL RESPONSE', 'LOGS', 2, 1, '/parcelResponse', 'API HISTORY LOG');
