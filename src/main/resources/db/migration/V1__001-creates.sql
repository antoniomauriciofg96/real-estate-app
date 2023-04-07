create database real_estate_db;

\connect real_estate_db;

create table public.users(
    id bigserial primary key,
    name varchar(100) not null,
    createdat timestamp(0) default now() not null,
    updatedat timestamp(0) default now() not null
);
COMMENT ON TABLE public.users IS 'Tabela com os dados de usuarios';
COMMENT ON COLUMN public.users.id IS 'Id do usuario';
COMMENT ON COLUMN public.users.name IS 'Nome do usuario';
COMMENT ON COLUMN public.users.createdat IS 'Data de criação do usuario';
COMMENT ON COLUMN public.users.updatedAt IS 'Data da última atualização do usuario';



create table public.addresses(
    id bigserial primary key,
    street varchar(100) not null,
    district varchar(100) not null,
    cep varchar(8) not null,
    city varchar(100) not null,
    uf varchar(2) not null,
    complement varchar(50) null,
    number varchar(10) null,
    createdat timestamp(0) default now() not null,
    updatedat timestamp(0) default now() not null
);
COMMENT ON TABLE public.addresses IS 'Tabela com os dados de enderecos';
COMMENT ON COLUMN public.addresses.id IS 'Id do endereco';
COMMENT ON COLUMN public.addresses.street IS 'Rua do endereco';
COMMENT ON COLUMN public.addresses.district IS 'Bairro do endereco';
COMMENT ON COLUMN public.addresses.cep IS 'CEP do endereco';
COMMENT ON COLUMN public.addresses.city IS 'Cidade do endereco';
COMMENT ON COLUMN public.addresses.uf IS 'UF do endereco';
COMMENT ON COLUMN public.addresses.complement IS 'Complemento do endereco';
COMMENT ON COLUMN public.addresses.number IS 'Numero do endereco';
COMMENT ON COLUMN public.addresses.createdat IS 'Data de criação do endereco';
COMMENT ON COLUMN public.addresses.updatedAt IS 'Data da última atualização do endereco';



create table public.properties(
    id bigserial primary key,
    title varchar(100) not null,
    avalilable_in timestamp not null,
    value numeric(10,3) not null,
    description varchar(500) null,
    area int not null,
    "type" varchar(100) not null,
    address_id int8 not null,
    status int default 1 not null,
    user_id int8 not null,
    createdat timestamp(0) default now() not null,
    updatedat timestamp(0) default now() not null
);
COMMENT ON TABLE public.properties IS 'Tabela com os dados de propriedades';
COMMENT ON COLUMN public.properties.id IS 'Id da propriedade';
COMMENT ON COLUMN public.properties.title IS 'Nome da propriedade';
COMMENT ON COLUMN public.properties.avalilable_in IS 'Data de disponibilidade da propriedade';
COMMENT ON COLUMN public.properties.value IS 'Valor da propriedade';
COMMENT ON COLUMN public.properties.description IS 'Descricao da propriedade';
COMMENT ON COLUMN public.properties.area IS 'Area da propriedade';
COMMENT ON COLUMN public.properties."type" IS 'Tipo da propriedade';
COMMENT ON COLUMN public.properties.address_id IS 'Id do endereço da propriedade';
COMMENT ON COLUMN public.properties.status IS 'Status da propriedade';
COMMENT ON COLUMN public.properties.user_id IS 'Id do usuário que cadastrou a propriedade';
COMMENT ON COLUMN public.properties.createdat IS 'Data de criação da propriedade';
COMMENT ON COLUMN public.properties.updatedAt IS 'Data da última atualização da propriedade';





