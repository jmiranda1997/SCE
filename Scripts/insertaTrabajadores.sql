DELIMITER //
DROP FUNCTION IF EXISTS creaTrabajadores//
CREATE FUNCTION creaTrabajadores (vDPI VARCHAR(45), vNombre VARCHAR(45), vApellido VARCHAR(45), vTelefono VARCHAR(45), vComision FLOAT, vDireccion VARCHAR(45), vSalario FLOAT, vBono FLOAT, vFechaInicio DATE, vFechaBono DATE) RETURNS INT
BEGIN
	DECLARE cuenta INT UNSIGNED DEFAULT 0;
	SELECT COUNT(*) FROM Trabajador WHERE DPI=vDPI INTO cuenta;
	#Si ya hay algun trabajador con este DPI, no se ingresa, y se devuelve 0
	IF(cuenta!=0) THEN
		RETURN 0;
	ELSE
		#Si no existe, se ingresan los datos, y se retorna 1
		INSERT INTO Trabajador (DPI, Nombre, Apellido, Telefono, Comision, Direccion, SalarioBase, BonoIncentivo, FechaDeInicio, FechaBono) VALUES (vDPI, vNombre, vApellido, vTelefono, vComision, vDireccion, vSalario,vBono,vFechaInicio,vFechaBono);
		RETURN 1;
	END IF;
END//
DELIMITER ;