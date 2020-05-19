DROP TABLE IF EXISTS CARRIER_SERVICE_CODE;
CREATE
	TABLE
		CARRIER_SERVICE_CODE (CARRIER_CODE VARCHAR(255),
		CARRIER_SHIPMENT_SERVICE VARCHAR(255),
		DESCRIPTION VARCHAR(255),
		PRIMARY KEY (CARRIER_CODE, CARRIER_SHIPMENT_SERVICE),
		CREATED_DATE_TIME TIMESTAMPTZ,
        	CREATED_USER VARCHAR(255),
    		LAST_UPDATED_DATE_TIME TIMESTAMPTZ,
      		LAST_UPDATED_USER VARCHAR(255)
);

DROP TABLE IF EXISTS CARRIER_PACKAGE_CODE;
CREATE
	TABLE
		CARRIER_PACKAGE_CODE (CARRIER_CODE VARCHAR(255),
		CARRIER_PACKAGE_CODE VARCHAR(255),
		DESCRIPTION VARCHAR(255),
		PRIMARY KEY(CARRIER_CODE, CARRIER_PACKAGE_CODE),
		CREATED_DATE_TIME TIMESTAMPTZ,
        	CREATED_USER VARCHAR(255),
        	LAST_UPDATED_DATE_TIME TIMESTAMPTZ,
        	LAST_UPDATED_USER VARCHAR(255)
		);


INSERT INTO CARRIER_SERVICE_CODE (CARRIER_CODE, CARRIER_SHIPMENT_SERVICE, DESCRIPTION, CREATED_DATE_TIME, CREATED_USER, LAST_UPDATED_DATE_TIME, LAST_UPDATED_USER) values ('UPS', '01', 'Next Day Air', now(), 'user', now(), 'user'),
('UPS', '02', 'Second Day Air', now(), 'user', now(), 'user'),
('UPS', '03', 'Ground', now(), 'user', now(), 'user'),
('UPS', '07', 'Express', now(), 'user', now(), 'user'),
('UPS', '08', 'Expedited', now(), 'user', now(), 'user'),
('UPS', '11', 'UPS Standard', now(), 'user', now(), 'user'),
('UPS', '12', '3 Day Select', now(), 'user', now(), 'user'),
('UPS', '13', 'Next Day Air Saver', now(), 'user', now(), 'user'),
('UPS', '14', 'UPS Next Day Air® Early', now(), 'user', now(), 'user'),
('UPS', '17', 'UPS Worldwide Economy DDU', now(), 'user', now(), 'user'),
('UPS', '54', 'Express Plus', now(), 'user', now(), 'user'),
('UPS', '59', '2nd Day Air A.M.', now(), 'user', now(), 'user'),
('UPS', '65', 'UPS Saver', now(), 'user', now(), 'user'),
('UPS', 'M2', 'First Class Mail', now(), 'user', now(), 'user'),
('UPS', 'M3', 'Priority Mail', now(), 'user', now(), 'user'),
('UPS', 'M4', 'Expedited MaiI Innovations', now(), 'user', now(), 'user'),
('UPS', 'M5', 'Priority Mail Innovations', now(), 'user', now(), 'user'),
('UPS', 'M6', 'Economy Mail Innovations', now(), 'user', now(), 'user'),
('UPS', 'M7', 'MaiI Innovations (MI) Returns 70 = UPS Access Point™ Economy', now(), 'user', now(), 'user'),
('UPS', '71', 'UPS Worldwide Express Freight Midday', now(), 'user', now(), 'user'),
('UPS', '72', 'UPS Worldwide Economy', now(), 'user', now(), 'user'),
('UPS', '74', 'UPS Express®12:00', now(), 'user', now(), 'user'),
('UPS', '82', 'UPS Today Standard', now(), 'user', now(), 'user'),
('UPS', '83', 'UPS Today Dedicated Courier', now(), 'user', now(), 'user'),
('UPS', '84', 'UPS Today Intercity', now(), 'user', now(), 'user'),
('UPS', '85', 'UPS Today Express', now(), 'user', now(), 'user'),
('UPS', '86', 'UPS Today Express Saver', now(), 'user', now(), 'user'),
('UPS', '96', 'UPS Worldwide Express Freight.', now(), 'user', now(), 'user');

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