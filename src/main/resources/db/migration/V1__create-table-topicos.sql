create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    curso varchar(100) not null unique,

    primary key(id)

    );