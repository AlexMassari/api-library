# api-library

La api-library es una aplicación desarrollada en Java utilizando el framework Spring Boot.

Esta API proporciona un conjunto de endpoints que permiten gestionar las actividades básicas de una biblioteca, como por ejemplo

registro de libros, listado de libros por autor o editorial, registro de socios, administracion de préstamos, etc.

------------------------------------------------------------------------------------------------------------------------------------------------------------

Características Principales

Gestión de Libros: Permite agregar, actualizar, eliminar y listar información de libros de la biblioteca. Cada libro contiene datos como título, autor, género, año de publicación, editorial y cantidad.

Gestión de Socios: Ofrece la posibilidad de registrar y administrar información de los miembros de la biblioteca, incluyendo nombre, direccion, teléfono, email y fecha de registro.

Gestión de Préstamos: Permite administrar los préstamos de libros a socios. Cada préstamo incluye detalles como el número de socio, el libro prestado, la fecha de inicio, la fecha de devolución y el estado del préstamo.

Gestión de Autores y Editoriales: Proporciona endpoints para administrar información de autores y editoriales.

------------------------------------------------------------------------------------------------------------------------------------------------------------

Tecnologías Utilizadas

Java: La aplicación está desarrollada en el lenguaje de programación Java.

Spring Boot: Se utiliza el framework Spring Boot para simplificar el desarrollo, la configuración y la creación de la API.

Swagger: La API está documentada usando Swagger, lo que permite a los desarrolladores comprender fácilmente los endpoints disponibles.

Base de Datos H2: La base de datos H2 en memoria se utiliza para almacenar los datos de la biblioteca. 
