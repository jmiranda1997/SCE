DELIMITER //
DROP FUNCTION IF EXISTS creaClientes//
CREATE FUNCTION creaClientes (vNombre VARCHAR(45), vApellido VARCHAR(45), vDescuento INT, vDireccion LONGTEXT, vCredito INT, vNIT VARCHAR(45), vCheque TINYINT) RETURNS INT
BEGIN
	DECLARE cuenta INT UNSIGNED DEFAULT 0;
	SELECT COUNT(*) FROM cliente WHERE NIT=vNIT INTO cuenta;
	#Si ya hay algun cliente con este nit, no se ingresa, y se devuelve 0
	IF(cuenta!=0) THEN
		RETURN 0;
	ELSE
		#Si no existe, se ingresan los datos, y se retorna 1
		INSERT INTO cliente (nombre, apellido, descuento, direccion, limitecredito, nit, cheque) VALUES (vNombre, vApellido, vDescuento, vDireccion, vCredito, vNIT,vCheque);
		RETURN 1;
	END IF;
END//
DELIMITER ;