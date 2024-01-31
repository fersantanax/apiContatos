create table categoria(
id uuid primary key,
nome varchar(25) not null unique
);

create table contato(
id uuid primary key,
nome varchar(150) not null,
telefone varchar(15) not null,
FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);