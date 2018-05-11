DROP TABLE  duenno cascade constraints;
DROP TABLE jugador cascade constraints;
DROP TABLE partido cascade constraints;
drop table equipo cascade constraints;
drop table jornada cascade constraints;
drop table usuarios cascade constraints;
drop table peticion cascade constraints;

CREATE TABLE peticion(
  
  codPeticion INTEGER GENERATED ALWAYS AS IDENTITY ,
  codDuenno INTEGER,
  nickname VARCHAR(15),
  nombre VARCHAR(15),
  apellido VARCHAR(15),
  sueldo INTEGER,
  contrasenna VARCHAR(15),
  permiso VARCHAR(15),
  tipo VARCHAR(15)
);
ALTER TABLE peticion ADD CONSTRAINT peticion_PK PRIMARY KEY ( codPeticion ) ;

CREATE TABLE duenno
  (
    codDuenno           INTEGER GENERATED ALWAYS AS IDENTITY ,
    equipo_codEquipo    INTEGER ,
    usuarios_codUsuario INTEGER NOT NULL
  ) ;
ALTER TABLE duenno ADD CONSTRAINT duenno_PK PRIMARY KEY ( codDuenno ) ;


CREATE TABLE equipo
  (
    codEquipo        INTEGER GENERATED ALWAYS AS IDENTITY ,
    nombre           VARCHAR2 (10) UNIQUE NOT NULL ,
    duenno_codDuenno INTEGER NOT NULL
  ) ;
ALTER TABLE equipo ADD CONSTRAINT equipo_PK PRIMARY KEY ( codEquipo ) ;


CREATE TABLE jornada
  (
    codJornada    INTEGER GENERATED ALWAYS AS IDENTITY ,
    fechaJornadaI DATE NOT NULL ,
    fechaJornadaF DATE NOT NULL
  ) ;
ALTER TABLE jornada ADD CONSTRAINT jornada_PK PRIMARY KEY ( codJornada ) ;


CREATE TABLE jugador
  (
    codJugador       INTEGER GENERATED ALWAYS AS IDENTITY ,
    nombre           VARCHAR2 (10) NOT NULL ,
    apellido         VARCHAR2 (15) ,
    nickname         VARCHAR2 (10) UNIQUE NOT NULL ,
    sueldo           INTEGER ,
    equipo_codEquipo INTEGER
  ) ;
ALTER TABLE jugador ADD CONSTRAINT jugador_PK PRIMARY KEY ( codJugador ) ;


CREATE TABLE partido
  (
    codPartido         INTEGER GENERATED ALWAYS AS IDENTITY ,
    fecha              DATE NOT NULL ,
    hora               VARCHAR2 (5) NOT NULL ,
    jugado             VARCHAR2 (10) default 'false' ,
    jornada_codJornada INTEGER NOT NULL ,
    equipo_codEquipoVisitante   INTEGER NOT NULL ,
    equipo_codEquipoLocal  INTEGER NOT NULL ,
    resultadoEL        INTEGER default 0 ,
    resultadoEV        INTEGER default 0
  ) ;
ALTER TABLE partido ADD CONSTRAINT partido_PK PRIMARY KEY ( codPartido ) ;


CREATE TABLE usuarios
  (
    codUsuario  INTEGER GENERATED ALWAYS AS IDENTITY ,
   nickname     VARCHAR2 (15) UNIQUE NOT NULL ,
    nombre     VARCHAR2 (15) NOT NULL ,
    apellido     VARCHAR2 (15) NOT NULL ,
    contrasenna VARCHAR2 (15) NOT NULL ,
    permiso     VARCHAR2 (15) NOT NULL
  ) ;
ALTER TABLE usuarios ADD CONSTRAINT usuarios_PK PRIMARY KEY ( codUsuario ) ;


ALTER TABLE duenno ADD CONSTRAINT duenno_equipo_FK FOREIGN KEY ( equipo_codEquipo ) REFERENCES equipo ( codEquipo ) ON
DELETE CASCADE ;

ALTER TABLE duenno ADD CONSTRAINT duenno_usuarios_FK FOREIGN KEY ( usuarios_codUsuario ) REFERENCES usuarios ( codUsuario ) ;

ALTER TABLE equipo ADD CONSTRAINT equipo_duenno_FK FOREIGN KEY ( duenno_codDuenno ) REFERENCES duenno ( codDuenno ) ON
DELETE CASCADE ;

ALTER TABLE jugador ADD CONSTRAINT jugador_equipo_FK FOREIGN KEY ( equipo_codEquipo ) REFERENCES equipo ( codEquipo ) ON
DELETE CASCADE ;

ALTER TABLE partido ADD CONSTRAINT partido_equipo_FK FOREIGN KEY ( equipo_codEquipoVisitante ) REFERENCES equipo ( codEquipo ) ON
DELETE CASCADE ;

ALTER TABLE partido ADD CONSTRAINT partido_equipo_FKv1 FOREIGN KEY ( equipo_codEquipoLocal ) REFERENCES equipo ( codEquipo ) ON
DELETE CASCADE ;

ALTER TABLE partido ADD CONSTRAINT partido_jornada_FK FOREIGN KEY ( jornada_codJornada ) REFERENCES jornada ( codJornada ) ON
DELETE CASCADE ;


--TRIGGERS
set serveroutput on;

CREATE OR REPLACE TRIGGER maxJugadores
BEFORE INSERT ON jugador for each row
DECLARE
    numJugadores int;
BEGIN
    select count(codJugador) into numJugadores from jugador where :new.equipo_codEquipo =  equipo_codEquipo;
    if numJugadores >=6 then
        Raise_Application_Error(-20001, 'LÍMITE DE JUGADORES');
    end if;
END;

CREATE OR REPLACE TRIGGER maxSalarioEquipo
BEFORE INSERT ON jugador for each row
DECLARE
    SalarioEquipo int;
BEGIN
    if :new.equipo_codEquipo is null then
        dbms_output.put_line(' ');
    else
        select sum(sueldo) into SalarioEquipo from jugador where Equipo_Codequipo = :new.equipo_codEquipo;
        if (salarioEquipo+:new.sueldo) >=200000 then
            Raise_Application_Error(-20002, 'LÍMITE DE SALARIO DE JUGADORES');
        end if;
    end if;    
END;


--PRODECIMIENTOS ALMACENADOS
drop procedure insertarJugador;
CREATE PROCEDURE insertarJugador(nombreJugador   VARCHAR2,  apellidoJugador VARCHAR2, nicknameJugador VARCHAR2, sueldo number, codEquipoJugador number)
IS
BEGIN
  INSERT INTO jugador(nombre,  apellido, nickname, sueldo , equipo_codEquipo)
     VALUES (INITCAP(nombreJugador),  INITCAP(apellidoJugador),  UPPER(nicknameJugador), sueldo, codEquipoJugador);
END;

DROP PROCEDURE IN_VER_JORNADA;
CREATE PROCEDURE IN_VER_JORNADA(cod OUT INTEGER, FECHAI IN DATE, FECHAF IN DATE)
Is
BEGIN
  INSERT INTO JORNADA VALUES(DEFAULT, FECHAI, FECHAF);
  SELECT MAX(CODJORNADA) INTO cod FROM JORNADA;
END IN_VER_JORNADA;

--PAQUETE1
CREATE OR REPLACE PACKAGE INSERTAR1
AS
  PROCEDURE IN_VER_JORNADA(cod OUT INTEGER, FECHAI IN DATE, FECHAF IN DATE);
  PROCEDURE insertarJugador(nombreJugador VARCHAR2,  apellidoJugador VARCHAR2, nicknameJugador VARCHAR2, sueldo number, codEquipoJugador number);
END;
/
CREATE OR REPLACE PACKAGE BODY INSERTAR1
AS

  PROCEDURE IN_VER_JORNADA(cod OUT INTEGER, FECHAI IN DATE, FECHAF IN DATE)
    IS
  BEGIN
    INSERT INTO JORNADA VALUES(DEFAULT, FECHAI, FECHAF);
    SELECT MAX(CODJORNADA) INTO cod FROM JORNADA;
  END IN_VER_JORNADA;
  
  PROCEDURE insertarJugador(nombreJugador VARCHAR2,  apellidoJugador VARCHAR2, nicknameJugador VARCHAR2, sueldo number, codEquipoJugador number)
  IS
  BEGIN
    INSERT INTO jugador(nombre,  apellido, nickname, sueldo, equipo_codEquipo)
     VALUES (INITCAP(nombreJugador),  INITCAP(apellidoJugador), UPPER(nicknameJugador), sueldo, codEquipoJugador);
  END insertarJugador;
  
END INSERTAR1;
/
--PAQUETE2
CREATE OR REPLACE PACKAGE MODIFICAR1
AS
  PROCEDURE ANADIR_JUG_EQUIP(NOMBRE_EQUIPO VARCHAR2, CODJ NUMBER);
  PROCEDURE ANADIR_EQUI_DUENNO(CODD NUMBER, NOMBRE_EQUIPO VARCHAR2);
END;
/
CREATE OR REPLACE PACKAGE BODY MODIFICAR1
AS

  PROCEDURE ANADIR_JUG_EQUIP(NOMBRE_EQUIPO VARCHAR2, CODJ NUMBER)
  IS
    E_COD NUMBER;
  BEGIN
    SELECT CODEQUIPO INTO E_COD FROM EQUIPO WHERE NOMBRE = NOMBRE_EQUIPO;
    UPDATE JUGADOR
      SET EQUIPO_CODEQUIPO = E_COD
    WHERE CODJUGADOR = CODJ;
  END ANADIR_JUG_EQUIP;
  
  PROCEDURE ANADIR_EQUI_DUENNO(CODD NUMBER, NOMBRE_EQUIPO VARCHAR2)
  IS
    E_COD NUMBER;
  BEGIN
    SELECT CODEQUIPO INTO E_COD FROM EQUIPO WHERE NOMBRE = NOMBRE_EQUIPO;
    UPDATE DUENNO
      SET EQUIPO_CODEQUIPO = E_COD
    WHERE CODDUENNO = CODD;
  END ANADIR_EQUI_DUENNO;
  
END MODIFICAR1;
/


