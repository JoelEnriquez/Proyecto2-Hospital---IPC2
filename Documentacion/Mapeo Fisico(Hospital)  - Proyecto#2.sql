DROP DATABASE HOSPITAL;
CREATE DATABASE HOSPITAL;
USE HOSPITAL;

CREATE TABLE IF NOT EXISTS PACIENTE(
	codigo INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(80) NOT NULL,
	sexo VARCHAR(10) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	DPI VARCHAR(15) NOT NULL,
	telefono VARCHAR(11) NOT NULL,
	peso VARCHAR(2) NOT NULL,
	tipo_sangre VARCHAR(3) NOT NULL,
	correo_electronico VARCHAR(60) NOT NULL,
	password VARCHAR(50) NOT NULL,

	PRIMARY KEY (codigo)
);


CREATE TABLE IF NOT EXISTS ADMINISTRADOR (
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	DPI VARCHAR(15) NOT NULL,
	password VARCHAR(50) NOT NULL,

	PRIMARY KEY (codigo)
);


CREATE TABLE IF NOT EXISTS MEDICO (
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	numero_colegiado VARCHAR(8) NOT NULL,
	horario_inicio TIME NOT NULL,
	horario_fin TIME NOT NULL,
	DPI VARCHAR(15) NOT NULL,
	telefono VARCHAR(11) NOT NULL,
	correo_electronico VARCHAR(60) NOT NULL,
	fecha_inicio_hospital DATE NOT NULL,
	password VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (codigo)
);


CREATE TABLE IF NOT EXISTS ESPECIALIDAD (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  costo_consulta DECIMAL(6) NOT NULL,

  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS ASIGNACION_ESPECIALIDAD (
	codigo_medico VARCHAR(10) NOT NULL,
	id_especialidad INT NOT NULL,

	PRIMARY KEY (codigo_medico, id_especialidad),
	FOREIGN KEY (codigo_medico)	REFERENCES MEDICO (codigo)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT,
	FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDAD (id)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS TIPO_EXAMEN (
  codigo INT NOT NULL AUTO_INCREMENT,
  nombre_examen VARCHAR(50) NOT NULL,
  descripcion VARCHAR(300) NOT NULL,
  costo DECIMAL(10) NOT NULL,
  formato_informe VARCHAR(5) NOT NULL,

  PRIMARY KEY (codigo)
);


CREATE TABLE IF NOT EXISTS LABORATORISTA (
  codigo VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  registro VARCHAR(45) NOT NULL,
  DPI VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  correo_electronico VARCHAR(60) NOT NULL,
  fecha_inicio_hospital DATE NOT NULL,
  password VARCHAR(50) NOT NULL,
  codigo_tipo_examen INT NOT NULL,

  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_tipo_examen) REFERENCES TIPO_EXAMEN(codigo)
);


CREATE TABLE IF NOT EXISTS ASIGNAR_DIAS_LAB (
  codigo_laboratorista VARCHAR(10) NOT NULL,
  lunes TINYINT NULL,
  martes TINYINT NULL,
  miercoles TINYINT NULL,
  jueves TINYINT NULL,
  viernes TINYINT NULL,
  sabado TINYINT NULL,
  domingo TINYINT NULL,

  PRIMARY KEY (codigo_laboratorista),
  FOREIGN KEY (codigo_laboratorista) REFERENCES LABORATORISTA(codigo)
);


CREATE TABLE IF NOT EXISTS CITA_MEDICO (
  codigo INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  codigo_paciente INT NOT NULL,
  codigo_medico VARCHAR(10) NOT NULL,
  id_especialidad INT NOT NULL,
  especialidad_cita VARCHAR(45) NOT NULL,  
  costo_consulta DECIMAL(6) NOT NULL, 

  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_paciente) REFERENCES PACIENTE(codigo),
  FOREIGN KEY (codigo_medico) REFERENCES MEDICO(codigo),
  FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDAD(id)
);


CREATE TABLE IF NOT EXISTS EXAMEN (
  codigo INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  requiere_orden BOOLEAN NOT NULL,
  codigo_paciente INT NOT NULL,
  codigo_medico VARCHAR(10) NULL,
  codigo_tipo_examen INT NOT NULL,

  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_paciente) REFERENCES PACIENTE(codigo),
  FOREIGN KEY (codigo_medico) REFERENCES MEDICO(codigo),
  FOREIGN KEY (codigo_tipo_examen) REFERENCES TIPO_EXAMEN(codigo)
);


CREATE TABLE IF NOT EXISTS INFORME_MEDICO (
  codigo INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  codigo_paciente INT NOT NULL,
  codigo_medico VARCHAR(10) NOT NULL,
  codigo_cita_medico INT NOT NULL,

  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_paciente) REFERENCES PACIENTE(codigo),
  FOREIGN KEY (codigo_medico) REFERENCES MEDICO(codigo),
  FOREIGN KEY (codigo_cita_medico) REFERENCES CITA_MEDICO(codigo)
);


CREATE TABLE IF NOT EXISTS RESULTADO_EXAMEN (
  codigo INT NOT NULL AUTO_INCREMENT,
  orden MEDIUMBLOB NULL,
  informe MEDIUMBLOB NOT NULL,
  hora TIME NOT NULL,
  fecha DATE NOT NULL,
  codigo_paciente INT NOT NULL,
  codigo_medico VARCHAR(10) NULL,
  codigo_laboratorista VARCHAR(10) NOT NULL,
  codigo_examen INT NOT NULL,

  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_paciente) REFERENCES PACIENTE(codigo),
  FOREIGN KEY (codigo_medico) REFERENCES MEDICO(codigo),
  FOREIGN KEY (codigo_laboratorista) REFERENCES LABORATORISTA(codigo),
  FOREIGN KEY (codigo_examen) REFERENCES EXAMEN(codigo)
);


