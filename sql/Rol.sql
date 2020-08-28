CREATE TABLE
ROL
(
ID_ROL INTEGER NOT NULL,
NOMBRE VARCHAR(30) NOT NULL,
DESCRIPCION VARCHAR(40)
);

ALTER TABLE ROL
ADD (
CONSTRAINT PK_ROL PRIMARY KEY (ID_ROL)
, CONSTRAINT uk_rol_nomb UNIQUE (nombre)
);
 
DROP SEQUENCE seq_id_rol;

CREATE SEQUENCE seq_id_rol
START WITH 1
INCREMENT BY 1;