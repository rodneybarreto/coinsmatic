create table coins(
    id bigint auto_increment primary key,
    code varchar(10) not null unique,
    name varchar(50) not null,
    description varchar(255),
    value double not null
);

create table emissions(
    id bigint auto_increment primary key,
    year int not null,
    production long,
    mbc_value double default 0 comment 'Muito Bem Conservada',
    s_value double default 0 comment 'Soberba',
    fc_value double default 0 comment 'Flor de Cunho',
    coin_id bigint,
    foreign key (coin_id) references coins(id)
);

create table defects(
    id bigint auto_increment primary key,
    year int not null,
    description varchar(255) not null,
    estimated_value double default 0,
    coin_id bigint,
    foreign key (coin_id) references coins(id)
);