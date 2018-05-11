
select equipo_codequipolocal, (sum(resultadoeL) + sum(resultadoeV)) clasificacion  from partido group  by equipo_Codequipolocal;

update partido set Resultadoel=3 where Equipo_Codequipovisitante=1;


select * from jugador;
select * from partido;
select * from equipo;
select codduenno from usuarios, duenno where usuarios.codusuario = Duenno.Usuarios_Codusuario and Usuarios.Nickname=? ; 
select * from duenno;

select * from jornada;
select max(codJornada) from jornada;
delete from equipo;
select * from partido order by Jornada_Codjornada asc;
update partido set jugado = 'true' where jornada_codjornada=1;
update partido set jugado = 'true' where codpartido=1072;

select * from duenno;
SELECT * FROM jugador where equipo_codequipo is null ;
select * from usuarios;
desc duenno;
commit;
insert into usuarios (nickname,nombre, apellido, contrasenna, permiso) values ('duenno','duenno','duenno',123,'duenno');
insert into usuarios (nickname,nombre, apellido, contrasenna, permiso) values ('admin','admin','admin',123,'administrador');
insert into usuarios (nickname,nombre, apellido, contrasenna, permiso) values ('usu','usuario','usuario',123,'usuario');
insert into usuarios (nickname, contrasenna, permiso) values ('juanxx',123,'duenno');
insert into usuarios (nickname, contrasenna, permiso) values ('igorxx',123,'duenno');
insert into usuarios (nickname, contrasenna, permiso) values ('manuxx',123,'duenno');
insert into usuarios (nickname, contrasenna, permiso) values ('alexuu',123,'duenno');
insert into usuarios (nickname, contrasenna, permiso) values ('rafuu',123,'duenno');

insert into duenno (usuarios_codusuario) values (1);
insert into duenno (usuarios_codusuario) values (2);
insert into duenno (usuarios_codusuario) values (3);
insert into duenno (nombre, apellido, usuarios_codusuario) values ('manu','ela',5);
insert into duenno (nombre, apellido, usuarios_codusuario) values ('igor','cesar',6);
insert into duenno (nombre, apellido, usuarios_codusuario) values ('manu','ela',7);

select * from equipo;
delete from equipo;
insert into equipo (nombre, duenno_codduenno) values ('SKT1', 1);
insert into equipo (nombre, duenno_codduenno) values ('BASKONIA', 2);
insert into equipo (nombre, duenno_codduenno) values ('CLOUD9', 3);
insert into equipo (nombre, duenno_codduenno) values ('FANATIC', 4);
insert into equipo (nombre, duenno_codduenno) values ('JAJA', 6);
insert into equipo (nombre, duenno_codduenno) values ('XDDDDD', 7);




select * from jugador;
SELECT * FROM jugador where equipo_codequipo = 4;
insert into jugador (nombre, apellido,nickname,sueldo, equipo_codEquipo) values ('manu','ela','mauee',2000,1);
insert into jugador (nombre, apellido,nickname,sueldo, equipo_codEquipo) values ('manu','ela','fakee',2000,1);
insert into jugador (nombre, apellido,nickname,sueldo, equipo_codEquipo) values ('manu','ela','xddd',2000,1);
insert into jugador (nombre, apellido,nickname) values ('rafa','rafa','rafa');

insert into duenno (nombre, apellido, usuarios_codusuario) values ('igor','cesar',6);
insert into duenno (nombre, apellido, usuarios_codusuario) values ('manu','ela',7);



delete from jornada;
delete from partido;
select * from jornada;
select * from usuarios;
select * from partido order by Jornada_Codjornada  asc;

insert into partido (fecha, hora, jugado, jornada_codjornada, equipo_codequipovisitante, equipo_codequipolocal, resultadoeL, resultadoeV) values (To_Date('13/12/18', 'dd/MM/yy'), '15:00', 'false', 605, 48, 51, 1, 1);

commit;
