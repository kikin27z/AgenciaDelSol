Use agencia;
DELIMITER //

CREATE PROCEDURE insercion_masiva ()
BEGIN
	INSERT INTO personas (`nombres`,`apellido_paterno`,`apellido_materno`,  `curp`, `discapacitado`, `fecha_nacimiento`,  `rfc`, `telefono`) VALUES
    ('Jose Karim', 'Franco', 'Valencia', 'FAVK040327HSRRLRA5','NORMAL', '2004-03-27', 'KUBV931119SF4', '6449393234'),
    ('Victor Humberto','Encinas','Guzman','EGCH040516HSRRLRA5','NORMAL','2004-05-16','MELM8305281H0','6646787333'),
    ('Esmeralda','Molina','Estrada','FOXP710322MMSBTG86','NORMAL','2004-02-23','RVJO130213NR3','6447779990'),
    ('Adriana','Gutierrez','Robles','GURA030404MSRTBDA8', 'DISCAPACITADO', '2003-04-04',  'GURA03040431','6442112147');
    
 
END //

DELIMITER ;