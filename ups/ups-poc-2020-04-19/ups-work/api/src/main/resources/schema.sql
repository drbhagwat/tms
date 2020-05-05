create table if not exists public.city(id SERIAL PRIMARY KEY, name varchar
(255), tenant_id varchar(255));

CREATE SEQUENCE if not exists "public".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;