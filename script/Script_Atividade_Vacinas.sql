create database atividade_vacina;
use atividade_vacina;

create table pessoa(
	id int not null auto_increment,
    nome varchar(150) not null,
    dtNascimento date not null,
    sexo char not null,
    cpf varchar(11) not null,
    notaAplicacao int not null,
    primary key(id)
);
create table publicGeral(
	id int not null auto_increment,
    idPessoa int not null,
    primary key(id),
    foreign key(idPessoa) references Pessoa(idPessoa)
);
create table Voluntario(
	id int not null auto_increment,
    idPessoa int not null,
    primary key(id),
    foreign key(idPessoa) references Pessoa(idPessoa)
);
create table pesquisador(
	id int not null auto_increment,
    idPessoa int not null,
    instituicao varchar(50) not null,
    primary key(id),
    foreign key(idPessoa) references Pessoa(idPessoa)
);
create table vacina(
	id int not null auto_increment,
    pais varchar(50) not null,
    estagio varchar(20),
    dtInicioPesquisa date not null,
    idPesquisador int not null,
    primary key(id),
    foreign key(idPesquisador) references Pesuisador(id)
);