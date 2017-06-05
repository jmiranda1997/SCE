DELIMITER //
DROP FUNCTION IF EXISTS login//
CREATE FUNCTION login (vNombre VARCHAR(45), vPass VARCHAR(45), vContraAComparar VARCHAR(45)) RETURNS INT
BEGIN
	DECLARE comparar INT UNSIGNED DEFAULT 0;
	DECLARE contraTemp LONGTEXT;
	DECLARE contraCif BLOB;
	#Verifica que el usuario no exista
	SELECT COUNT(*) FROM usuario WHERE Usuario=vNombre INTO comparar;
	IF (comparar!=0) THEN
		#Obtiene la contraseña cifrada
		SELECT Password FROM usuario WHERE Usuario=vNombre INTO contraCif;
		#Desencripta la contraseña en la BD, utilizando la clave recibida
		SET contraTemp=AES_DECRYPT(contraCif,vPass);
		#Compara si la contraseña introducida es igual a la desencriptada de la BD, se devuelve 1 si son iguales, 0 de lo contrario
		IF(STRCMP(vContraAComparar,contraTemp)=0) THEN
			RETURN 1;
		ELSE
			RETURN 0;
		END IF;
	ELSE
		RETURN 0;
	END IF;
END//
DELIMITER ;
