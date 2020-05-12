CREATE
	TABLE
		IF NOT EXISTS CARRIER_SERVICE_CODE (CARRIER_CODE VARCHAR(255) PRIMARY KEY,
		CARRIER_SHIPMENT_SERVICE VARCHAR(255),
		DESCRIPTION VARCHAR(255),
		CREATED_DATE_TIME TIMESTAMPTZ,
        CREATED_USER VARCHAR(255),
    	LAST_UPDATED_DATE_TIME TIMESTAMPTZ,
      	LAST_UPDATED_USER VARCHAR(255)
);

CREATE
	TABLE
		IF NOT EXISTS CARRIER_PACKAGE_CODE (CARRIER_CODE VARCHAR(255),
		CARRIER_PACKAGE_CODE VARCHAR(255),
		DESCRIPTION VARCHAR(255),
		PRIMARY KEY(CARRIER_CODE, CARRIER_PACKAGE_CODE),
		CREATED_DATE_TIME TIMESTAMPTZ,
        CREATED_USER VARCHAR(255),
        LAST_UPDATED_DATE_TIME TIMESTAMPTZ,
        LAST_UPDATED_USER VARCHAR(255)
		);

DELETE FROM CARRIER_SERVICE_CODE;

DELETE FROM CARRIER_PACKAGE_CODE;

INSERT INTO CARRIER_SERVICE_CODE (CARRIER_CODE, CARRIER_SHIPMENT_SERVICE, DESCRIPTION, CREATED_DATE_TIME, CREATED_USER, LAST_UPDATED_DATE_TIME, LAST_UPDATED_USER) values ('UPS', '01', 'Next Day Air', now(), 'user', now(), 'user');

INSERT INTO CARRIER_PACKAGE_CODE (CARRIER_CODE, CARRIER_PACKAGE_CODE, DESCRIPTION, CREATED_DATE_TIME, CREATED_USER, LAST_UPDATED_DATE_TIME, LAST_UPDATED_USER) VALUES
('UPS', '01', 'UPS Letter', now(), 'user', now(), 'user'),
('UPS', '02', 'Customer Supplied Package', now(), 'user', now(), 'user'),
('UPS', '03', 'Tube', now(), 'user', now(), 'user'),
('UPS', '04', 'PAK', now(), 'user', now(), 'user'),
('UPS', '21', 'UPS Express Box', now(), 'user', now(), 'user'),
('UPS', '24', 'UPS 25KG Box', now(), 'user', now(), 'user'),
('UPS', '25', 'UPS 10KG Box', now(), 'user', now(), 'user'),
('UPS', '30', 'Pallet', now(), 'user', now(), 'user'),
('UPS', '2a', 'Small Express Box', now(), 'user', now(), 'user'),
('UPS', '2b', 'Medium Express', now(), 'user', now(), 'user'),
('UPS', '2c', 'Large Express Box', now(), 'user', now(), 'user'),
('UPS', '56', 'Flats', now(), 'user', now(), 'user'),
('UPS', '57', 'Parcels', now(), 'user', now(), 'user'),
('UPS', '58', 'BPM', now(), 'user', now(), 'user'),
('UPS', '59', 'First Class', now(), 'user', now(), 'user'),
('UPS', '60', 'Priority', now(), 'user', now(), 'user'),
('UPS', '61', 'Machineables', now(), 'user', now(), 'user'),
('UPS', '62', 'Irregulars', now(), 'user', now(), 'user'),
('UPS', '63', 'Parcel Post', now(), 'user', now(), 'user'),
('UPS', '64', 'BPM Parcel', now(), 'user', now(), 'user'),
('UPS', '65', 'Media Mail', now(), 'user', now(), 'user'),
('UPS', '66', 'BPM Flat', now(), 'user', now(), 'user'),
('UPS', '67', 'Standard Flat', now(), 'user', now(), 'user');