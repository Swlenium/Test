Este repositorio contiene un ejemplo de pruebas de integración para una API REST.

Pre-requisitos
Java 8 o posterior
Maven
Instrucciones
Clona el repositorio: git clone https://github.com/[usuario]/[repositorio].git
Accede a la carpeta del proyecto: cd [test]
Ejecuta las pruebas con Maven: mvn test
Notas
Las pruebas utilizan la librería Rest-Assured para enviar peticiones a la API y validar las respuestas.

Las pruebas incluyen los siguientes casos:

Agregar una mascota
Obtener una mascota existente
Modificar una mascota existente
La API utilizada es la API PetStore disponible en https://petstore.swagger.io/ .
