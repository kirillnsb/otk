CREATE TABLE public.checkups
(
    checkup_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    employee_ref bigint NOT NULL,
    session_id bigint,
    quantity integer NOT NULL,
    invalid_quant integer,
    consign_num text COLLATE pg_catalog."default",
    item_type text COLLATE pg_catalog."default" NOT NULL,
    invalid_quantity integer
)
    TABLESPACE pg_default;



CREATE TABLE public.consignments
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    supplier_ref bigint
)

    TABLESPACE pg_default;


CREATE TABLE public.control_stations
(
    id bigint NOT NULL,
    type_ref bigint
)

    TABLESPACE pg_default;



CREATE TABLE public.item_types
(
    type_id bigint NOT NULL,
    type_name text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    CONSTRAINT item_types_pkey PRIMARY KEY (type_id)
)

    TABLESPACE pg_default;

ALTER TABLE public.item_types
    OWNER to postgres;


CREATE TABLE public.permissions
(
    pos_ref integer NOT NULL,
    "create" boolean NOT NULL,
    read boolean NOT NULL,
    update boolean NOT NULL,
    delete boolean NOT NULL
)

    TABLESPACE pg_default;


CREATE TABLE public.positions
(
    pos_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "position" text COLLATE pg_catalog."default" NOT NULL,
    salary integer,
    CONSTRAINT positions_pkey PRIMARY KEY (pos_id)
)

    TABLESPACE pg_default;

ALTER TABLE public.positions
    OWNER to postgres;

CREATE TABLE public.sessions
(
    id bigint NOT NULL,
    employee_ref bigint,
    date date,
    control_station_ref bigint,
    CONSTRAINT sessions_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;


CREATE TABLE public.staff
(
    employee_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    phone_num character varying(12) COLLATE pg_catalog."default",
    login character varying(20) COLLATE pg_catalog."default",
    password character varying(20) COLLATE pg_catalog."default",
    position_id bigint,
    CONSTRAINT staff_pkey PRIMARY KEY (employee_id)
)

    TABLESPACE pg_default;


CREATE TABLE public.standarts
(
    item_type text COLLATE pg_catalog."default",
    tolerance text COLLATE pg_catalog."default",
    item_ref bigint
)

    TABLESPACE pg_default;


CREATE TABLE public.suppliers
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    CONSTRAINT suppliers_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.suppliers
    OWNER to postgres;