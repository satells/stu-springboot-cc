﻿select * from pedido

select * from users
/*

drop table authorities;


drop table users;


select * from users


create table users(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

*/
update pedido set status='ENTREGUE' where id>50

