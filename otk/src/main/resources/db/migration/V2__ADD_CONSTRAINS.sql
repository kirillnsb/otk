ALTER TABLE public.checkups
ADD CONSTRAINT checkups_pkey PRIMARY KEY (checkup_id),
    ADD CONSTRAINT employee_id_fkey FOREIGN KEY (employee_ref)
        REFERENCES public.staff (employee_id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID,
    ADD CONSTRAINT session_fkey FOREIGN KEY (session_id)
        REFERENCES public.sessions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID;

ALTER TABLE public.consignments
ADD CONSTRAINT consignments_pkey PRIMARY KEY (id),
    ADD CONSTRAINT cons_sup_fkey FOREIGN KEY (supplier_ref)
        REFERENCES public.suppliers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID;

ALTER TABLE public.control_stations
ADD CONSTRAINT control_stations_pkey PRIMARY KEY (id),
    ADD CONSTRAINT type_fkey FOREIGN KEY (type_ref)
        REFERENCES public.item_types (type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID;

ALTER TABLE public.permissions
ADD CONSTRAINT perm_fkey FOREIGN KEY (pos_ref)
        REFERENCES public.positions (pos_id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID;

ALTER TABLE public.sessions
ADD CONSTRAINT con_station_fkey FOREIGN KEY (control_station_ref)
        REFERENCES public.control_stations (id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID ;

ALTER TABLE public.staff
ADD CONSTRAINT position_fkey FOREIGN KEY (position_id)
        REFERENCES public.positions (pos_id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID;

ALTER TABLE public.standarts
ADD CONSTRAINT item_fkey FOREIGN KEY (item_ref)
        REFERENCES public.item_types (type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
           ON DELETE NO ACTION
        NOT VALID   ;