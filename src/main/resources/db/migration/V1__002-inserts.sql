\connect real_estate_db;


INSERT INTO public.users (name) values('admin');


INSERT INTO public.addresses (street, district, cep, city, uf, complement, number) 
values('Rua Sena Madureira', 'Vila Clementino', '04021000', 'São Paulo', 'SP', '3o andar', '80');



INSERT INTO public.properties (title, avalilable_in, value, description, area, "type", address_id, status, user_id) 
values('Apartamento com 2 Quartos e 2 banheiros à Venda, 65 m² por R$ 400.000', 
'2023-04-07 00:00:00', 
400000.00, 
'Apartamento para venda com 65 metros quadrados com 2 quartos em Vila Clementino - São Paulo - SP', 
65, 
'APARTAMENTO', 
1,
1,
1);







