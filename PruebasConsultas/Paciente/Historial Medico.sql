INSERT INTO CITA_MEDICO VALUES (833415,'2020-02-09','09:00:00',118258,'MED-684',1,'Pediatria',156.0);
SELECT C.* FROM CITA_MEDICO CM INNER JOIN INFORME_MEDICO IM ON CM.codigo=IM.codigo_cita_medico;
SELECT E.* FROM EXAMEN E INNER JOIN RESULTADO_EXAMEN RE ON E.codigo=RE.codigo_examen;