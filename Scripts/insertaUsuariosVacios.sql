DELIMITER //
DROP FUNCTION IF EXISTS creacionUsuarioVacio//
CREATE FUNCTION creacionUsuarioVacio (vNombreUsuario VARCHAR(45), vContraUsuario VARCHAR(45), vPass VARCHAR(45), vTrabajadorID INT) RETURNS INT
BEGIN
	DECLARE comparar INT UNSIGNED DEFAULT 0;
	DECLARE IDUltimoUsuario INT UNSIGNED DEFAULT 0;
	#Verifica que el usuario no exista
	SELECT COUNT(*) FROM usuario WHERE Usuario=vNombreUsuario INTO comparar;
	#Si el usuario ya existe, se devuelve 0, de lo contrario, lo inserta y devuelve 1
	IF (comparar=0) THEN
		#Inserta el nuevo usuario en la BD, encriptando la contraseña con la clave enviada
		INSERT INTO usuario (Usuario, Password) VALUES (vNombreUsuario, AES_ENCRYPT(vContraUsuario,vPass));
		SELECT MAX(id) FROM Usuario INTO IDUltimoUsuario;
		UPDATE Trabajador SET Usuario_id=IDUltimoUsuario WHERE id=vTrabajadorID;
		RETURN 1;
	ELSE
		RETURN 0;
	END IF;
END//
DELIMITER ;
