# Proyecto Departamentos - Municipios

Este proyecto es una aplicación para la administración de departamentos y municipios de Colombia. Permite realizar las operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar) tanto para los departamentos como para los municipios, con funcionalidades como la creación de nuevos registros, la visualización de listas y la edición o eliminación de registros existentes.

---

## Requisitos

Para ejecutar este proyecto, necesitas contar con las siguientes herramientas:

- **Java 17 o superior** (Recomendado)
- **Maven 3.6 o superior** (Para la gestión de dependencias y construcción del proyecto)
- **Spring Boot** (Versión 2.x o superior)
- **Base de datos**:
  - MySQL o cualquier otra base de datos compatible con JDBC
  - Configuración adecuada del driver JDBC en el archivo application.properties.
- **IDE**:
  El IDE recomendado es Apcahe Netbeans aunque puedes usar otros como IntelliJ IDEA.

### Instalación y Configuración
1. **Clonar el repositorio**:
   git clone https://github.com/Migatte-Yk/Aplicacion-prueba.git

2. **Acceder al directorio del proyecto**:
cd crud

3. **Instalar dependencias con Maven**:
mvm clean install

4. **Scripts Base de datos**:
Deberas crear la base de datos SQL, ejecuta en tu MySQL (o el que estes usando) los siguientes scripts en orden:

- -- 1. Crear Base de Datos:

CREATE DATABASE colombia;
USE colombia;

- -- 2. Crear Tabla Departamentos:

CREATE TABLE DEPARTAMENTO (
    ID_DEPARTAMENTO BIGINT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    GOBERNADOR VARCHAR(50)NOT NULL
);

- -- 3. Crear Tabla Municipios:

CREATE TABLE MUNICIPIO (
    ID_MUNICIPIO BIGINT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    ID_DEPARTAMENTO BIGINT NOT NULL,
    CONSTRAINT FK_DEPARTAMENTO
        FOREIGN KEY (ID_DEPARTAMENTO) 
        REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO)
        ON UPDATE CASCADE
        ON DELETE CASCADE);

5. **Configurar la base de datos en el proyecto**: 
Abre tu IDE de preferencia y busca el archivo aplication.properties ahi deberas cambiar los siguientes parametros con los que tu tengas en tu base de datos.

- spring.datasource.url=jdbc:mysql://localhost:3306/colombia
- spring.datasource.username= tu_usuario
- spring.datasource.password= tu_contraseña 

asegurate de cambiar el puerto (3306) ya que puede variar.
