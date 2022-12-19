create table pessoas (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    identificador varchar(14) not null,
    tipo_identificador varchar(4) not null,

    primary key(id)

)