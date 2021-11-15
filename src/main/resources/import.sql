/**Tipos de documentos*/
INSERT INTO  tipos_documento (tipo) VALUES ('DNI');
INSERT INTO  tipos_documento (tipo) VALUES ('LE');
INSERT INTO  tipos_documento (tipo) VALUES ('LC');

/**candidatos*/
INSERT INTO  candidatos (apellido, fecha_nacimiento, nombre, numero_documento, id_tipo_documento) VALUES ('ortega', '2000-11-15', 'candidato1', '32424222', 1);
INSERT INTO  candidatos (apellido, fecha_nacimiento, nombre, numero_documento, id_tipo_documento) VALUES ('ortega', '2000-11-15', 'candidito2', '32421112', 3);
INSERT INTO  candidatos (apellido, fecha_nacimiento, nombre, numero_documento, id_tipo_documento) VALUES ('ortega', '2000-11-15', 'candidato3', '32422312', 1);

/**tecnologias*/
INSERT INTO  tecnologias (nombre, version) VALUES ('java', '1');
INSERT INTO  tecnologias (nombre, version) VALUES ('java', '2');
INSERT INTO  tecnologias (nombre, version) VALUES ('angular', '1');

/**candidato por tecnologias*/

INSERT INTO  tecnologias_por_candidato (anios_experiencia, id_candidato, id_tecnologia) VALUES (1, 1, 3);
INSERT INTO  tecnologias_por_candidato (anios_experiencia, id_candidato, id_tecnologia) VALUES (4, 2, 1);
INSERT INTO  tecnologias_por_candidato (anios_experiencia, id_candidato, id_tecnologia) VALUES (3, 1, 1);