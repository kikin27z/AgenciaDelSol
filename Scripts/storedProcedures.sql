Use agencia;
DELIMITER //

CREATE PROCEDURE insercion_masiva ()
BEGIN
	INSERT INTO personas (nombres,apellido_paterno,apellido_materno, discapacitado, fecha_nacimiento,  rfc, telefono) VALUES
    ('Jose Karim', 'Franco', 'Valencia', 'NORMAL', '2007-03-27', 'KUBV931119SF4', '6449393234'),
    ('Victor Humberto','Encinas','Guzman','NORMAL','2004-05-16','MELM8305281H0','6646787333'),
    ('Esmeralda','Molina','Estrada','NORMAL','2004-02-23','RVJO130213NR3','6447779990'),
    ('Adriana','Gutierrez','Robles','DISCAPACITADO', '2003-04-04',  'GURA03040431','6442112147'),
    ('Jesus Rene','Gonzalez','Castro','NORMAL', '2004-03-19',  'GOCJ040119GHA','6442522642'),
    ('Gael Rafael','Castro','Molina','NORMAL', '2004-06-16',  'CAMG040616IR6','6442266331'),
    ('Oliver','Inzunza','Valle','NORMAL', '2004-12-16',  'IUVO0407069Z3','6871568089'),
    ('Marian Isabel','Valdez','Villa','NORMAL', '2004-01-05',  'VAVM040105L89','6442522643'),
    ('Raul','Guillen','Rodriguez','NORMAL', '2004-04-01',  'GURR040401JC0','6442522645'),
    ('Hector Alberto','Espinoza','Duarte','NORMAL', '2004-09-21',  'ESDH040921GX8','6447879390'),
    ('Ricardo Alan','Garces','Gutierrez','NORMAL', '2004-04-21',  'GAGR040321611','6443522643'),
    ('Jose Luis','Madero','Lopez','DISCAPACITADO', '2004-06-26',  'MALL040626M67','678282828'),
    ('Jose Maria','Armenta','Baca','DISCAPACITADO', '2004-03-26',  'ARBM040626MD0','6623856789'),
    ('Enrique','Rodriguez','Angulo','NORMAL', '2004-03-04',  'ROAE040304DD0','6447890123'),
    ('David','Arvizu','Duarte','NORMAL', '2004-12-07',  'ARDD041207R43','6442678902'),
    ('Luisa', 'Torres', 'Sánchez','NORMAL', '1991-08-25', 'TOSL910825MDF', '6628765432'),
    ('Carlos', 'Díaz', 'López','DISCAPACITADO', '1994-07-02', 'DILC940702MDF', '6623456789'),
    ('Jorge', 'Gonzalez', 'Diaz','DISCAPACITADO', '1995-04-12', 'GODJ950412MDF', '6622345678'),
    ('Ana', 'Ramirez', 'Jimenez','NORMAL', '1990-06-23', 'RAJA900623MDF', '6627890123'),
    ('Pedro', 'Martinez', 'Gutierrez','NORMAL', '1992-12-15', 'MAGP921215HDF', '6624567890'),
	('Maria', 'Hernandez', 'Garcia','NORMAL', '1988-07-06', 'HEMG880706MDF', '6629876543'),
    ('Juan', 'Lopez', 'Gomez','DISCAPACITADO', '1992-05-18', 'LOGJ920518HDF', '6621234567');
END //

DELIMITER ;