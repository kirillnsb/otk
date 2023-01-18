INSERT INTO public.staff (
    name, login, password) VALUES
                               ('Ivanov'::text, 'ivanov1'::character varying, 'iva123'::character varying),
                               ('Petrov'::text, 'petrov2'::character varying, 'pet123'::character varying),
                               ('Sidorov'::text, 'sidorov3'::character varying, 'sid123'::character varying),
                               ('Romanov'::text, 'romanov4'::character varying, 'rom123'::character varying);

INSERT INTO public.checkups (
    employee_ref, quantity, invalid_quant, consign_num, item_type) VALUES
    ('1'::bigint, '42'::integer, '0'::integer, 'Con15'::text, 'R45'::text),
    ('2'::bigint, '16'::integer, '2'::integer, 'Con11'::text, 'C120'::text),
    ('1'::bigint, '32'::integer, '5'::integer, 'Con5'::text, 'L10'::text),
    ('3'::bigint, '97'::integer, '4'::integer, 'Con3'::text, 'R500'::text),
    ('3'::bigint, '61'::integer, '5'::integer, 'Con20'::text, 'C350'::text),
    ('1'::bigint, '27'::integer, '1'::integer, 'Con7'::text, 'L15'::text);

INSERT INTO public.item_types (
    type_name, description, type_id) VALUES
    ('R'::text, 'resistor'::text, '1'::bigint),
    ('L'::text, 'inductive'::text, '2'::bigint),
    ('C'::text, 'capacitor'::text, '3'::bigint);