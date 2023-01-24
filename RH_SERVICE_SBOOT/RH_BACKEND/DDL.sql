CREATE DEFINER=`root`@`localhost` PROCEDURE `Borra_Empleado`(IN pId int  )
    MODIFIES SQL DATA
    COMMENT 'Borra datos en la tabla Empleados desde Spring Boot'
BEGIN
       
 Delete from empleados 
 where  id = pId;    
    
    select 0;
END

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Inserta_Empleado`( IN pNombre varchar(60), IN pApellido varchar(60), 
IN pEmail varchar(60), IN pSalario double )
    MODIFIES SQL DATA
    COMMENT 'Inserta datos en la tabla Empleados desde Spring Boot'
BEGIN
    DECLARE ex_claveDuplicada CONDITION FOR 1062;
    DECLARE ex_pista_atracc_no_existe CONDITION FOR 1452;
    
    DECLARE EXIT HANDLER FOR ex_claveDuplicada
    BEGIN
        SELECT -1;
    END;
    DECLARE EXIT HANDLER FOR ex_pista_atracc_no_existe
    BEGIN
        SELECT -2;
    END;
 
 INSERT INTO empleados(nombre, apellido, email, salario)
 VALUES(pNombre, pApellido, pEmail, pSalario) ;
    
    select 0;
END

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Modifica_Empleado`(IN pId int, IN pNombre varchar(60), IN pApellido varchar(60), 
IN pEmail varchar(60), IN pSalario double )
    MODIFIES SQL DATA
    COMMENT 'Modifica datos en la tabla Empleados desde Spring Boot'
BEGIN
      
 
 UPDATE empleados
 set nombre =pNombre,
     apellido =pApellido, 
     email =pEmail, 
     salario=pSalario
 where  id = pId;    
    
    select 0;
END

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Mostrar_Planilla`()
    READS SQL DATA
BEGIN
   -- Create Index on fldCompanyName
DROP TABLE IF EXISTS temp_datos_planilla;
-- Create temporary table
CREATE TEMPORARY TABLE temp_datos_planilla 
   select
    row_number() over(order by a.idPlanilla)   as identificador, a.idPlanilla as id_planilla, 
    a.idEmpleado as id_empleado, Concat(b.nombre,' ', b.apellido) as nombres,
    a.Salario, a.Pago, a.Horas_trabajadas as horas_trabajadas
  from planilla a, empleados b
  where a.idEmpleado = b.id;
  
  /*and id = pIdEmpleado;*/
  
  select * from temp_datos_planilla;
    
END

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Mostrar_Planilla_Empleado`( IN  pIdEmpleado int )
    READS SQL DATA
BEGIN
  -- Create Index on fldCompanyName
DROP TABLE IF EXISTS temp_datos_planilla_Emp;

-- Create temporary table
CREATE TEMPORARY TABLE temp_datos_planilla_Emp 
   select
    row_number() over(order by a.idPlanilla)   as identificador, a.idPlanilla as id_planilla, 
    a.idEmpleado as id_empleado,Concat(b.nombre,' ', b.apellido) as nombres,
    a.Salario, a.Pago, a.Horas_trabajadas as horas_trabajadas
  from planilla a, empleados b
  where a.idEmpleado = b.id
  and a.idEmpleado = pIdEmpleado;
 

  select * from temp_datos_planilla_Emp;
    
END

DELIMITER $$

CREATE TABLE `empleados` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6fdpo2x5rmegfbngre7xb3yoh` (`email`)
) 

CREATE TABLE `planilla` (
  `idPlanilla` int NOT NULL,
  `idEmpleado` int NOT NULL,
  `Salario` double DEFAULT NULL,
  `Pago` double DEFAULT NULL,
  `Horas_trabajadas` int DEFAULT NULL,
  `Fecha_Planilla` date DEFAULT NULL,
  `identificador` int NOT NULL,
  PRIMARY KEY (`idPlanilla`,`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



