# Estructura básica de un proyecto Java con MVC y ObjectDB

## Descripción

Este proyecto es un ejemplo básico de una aplicación desarrollada en **Java utilizando Maven, ObjectDB y el patrón de arquitectura Modelo-Vista-Controlador (MVC)**.

Su propósito es demostrar cómo organizar un proyecto Java mediante la separación de responsabilidades, facilitando el desarrollo, mantenimiento y administración de la información almacenada en una base de datos orientada a objetos.

El proyecto utiliza como ejemplo un sistema sencillo de administración de productos de una papelería.

## Objetivo

Comprender e implementar una estructura básica de desarrollo Java utilizando MVC y una capa Repository para realizar operaciones de persistencia sobre una base de datos orientada a objetos mediante ObjectDB.

## Tecnologías utilizadas

| Tecnología | Descripción |
|---|---|
| Java | Lenguaje de programación |
| Maven | Administración de dependencias y construcción del proyecto |
| ObjectDB 2.9.5 | Base de datos orientada a objetos |
| JPA (`javax.persistence`) | API para administrar objetos persistentes |
| MVC | Patrón para separar responsabilidades |
| Repository | Capa encargada del acceso a la base de datos |

El proyecto tiene configurado Java 26 en el archivo `pom.xml`.

## Estructura del proyecto

```text
ProyectoBaseDboo/
│
├── pom.xml
│
├── data/
│   └── papeleriadb.odb
│
└── src/
    └── main/
        ├── java/
        │   └── mx/edu/tecmm/elgrullo/proyectobasedboo/
        │       │
        │       ├── ProyectoBaseDboo.java
        │       │
        │       ├── config/
        │       │   └── ConnectionService.java
        │       │
        │       ├── model/
        │       │   └── Producto.java
        │       │
        │       ├── view/
        │       │   └── ProductosView.java
        │       │
        │       ├── controller/
        │       │   └── ProductoController.java
        │       │
        │       └── repository/
        │           └── ProductoRepository.java
        │
        └── resources/
            └── META-INF/
                └── persistence.xml
```

## Descripción de los componentes

### Model

Contiene las clases que representan los objetos del sistema.

En este ejemplo, `Producto.java` representa una entidad persistente con atributos como código de barras, descripción, precio y estado.

### View

Se encarga de presentar la información al usuario.

La clase `ProductosView.java` contiene ejemplos básicos para registrar y mostrar productos utilizando la consola.

### Controller

Coordina las operaciones solicitadas desde la vista.

La clase `ProductoController.java` recibe los objetos y utiliza el repositorio para realizar las operaciones correspondientes.

### Repository

Es la capa responsable de comunicarse con ObjectDB.

La clase `ProductoRepository.java` implementa los siguientes métodos:

| Método | Función |
|---|---|
| `add()` | Registrar un producto |
| `find()` | Buscar un producto por su identificador |
| `findAll()` | Consultar productos activos |
| `update()` | Actualizar la información de un producto |

Las operaciones de escritura utilizan transacciones para administrar los cambios realizados en la base de datos.

### Config

Contiene la configuración del acceso a la base de datos.

La clase `ConnectionService.java` proporciona instancias de `EntityManager` para realizar operaciones de persistencia.

El archivo `persistence.xml` establece la conexión con ObjectDB mediante la unidad de persistencia `PapeleriaPU`.

## Funcionamiento de la arquitectura

El proyecto organiza las operaciones mediante el siguiente flujo:

```text
        USUARIO
           |
           v
     +------------+
     |    VIEW    |
     +------------+
           |
           v
     +------------+
     | CONTROLLER |
     +------------+
           |
           v
     +------------+
     | REPOSITORY |
     +------------+
           |
           v
     +------------+
     |  OBJECTDB  |
     +------------+
```

El modelo contiene las clases que representan la información utilizada por los diferentes componentes.

Esta organización permite mantener separadas la presentación, la coordinación de operaciones y la persistencia de datos.

## Ejecución del proyecto

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en un IDE compatible con Java y Maven.
3. Utilizar un JDK compatible con la versión configurada en `pom.xml`.
4. Permitir que Maven descargue las dependencias.
5. Ejecutar la clase principal `ProyectoBaseDboo.java`.

La clase principal contiene una llamada al método `listado()` de `ProductosView`, que permite consultar los productos activos almacenados.

También se incluye un ejemplo de registro mediante el método `registroProductos()`, cuya llamada se encuentra comentada en la clase principal.

## Propósito académico

Este repositorio fue desarrollado como material de apoyo para la asignatura **IFF-1026 - Tópicos de Bases de Datos**, de la carrera de Ingeniería Informática.

**Unidad II. Sistemas de bases de datos orientadas a objetos.**

El proyecto sirve como referencia para comprender la organización de aplicaciones Java, la persistencia de objetos y el uso de ObjectDB mediante JPA.

Se espera que los estudiantes puedan utilizar esta estructura como punto de partida para desarrollar sus propias aplicaciones, incorporando nuevos modelos, relaciones entre objetos, consultas y operaciones CRUD.

---

**Autor:** Luis Cobián  
**Asignatura:** Tópicos de Bases de Datos  
**Tecnológico Nacional de México**