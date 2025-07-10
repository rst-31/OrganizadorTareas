
# Aplicación de Gestión de Tareas - Java Swing

Esta es una aplicación de escritorio desarrollada en Java con Swing que permite gestionar tareas de forma intuitiva y visualmente moderna. El sistema permite agregar, eliminar, completar, ordenar y filtrar tareas según su estado y prioridad.

---

## Características principales

- **Agregar tareas** con nombre y prioridad (Alta, Media, Baja).
- **Eliminar tareas** seleccionadas de la lista.
- **Marcar tareas como completadas**.
- **Ordenar tareas por prioridad**, tanto de mayor a menor como inverso.
- **Filtrar tareas**:
  - Ver solo tareas completadas.
  - Ver solo tareas pendientes.
  - Ver todas las tareas.

- Interfaz moderna inspirada en paneles (dashboard), con navegación lateral.

---

## Tecnologías utilizadas

- Java 17+
- Swing (para la interfaz gráfica de usuario)
- GridBagLayout y BorderLayout (para diseño de interfaz)
- POO (Programación Orientada a Objetos)

---

## Estructura del proyecto
src/
├── Main.java # Clase principal, ventana principal de la aplicación
├── Tarea.java # Modelo de datos: representa una tarea
├── PanelCentral.java # Panel principal donde se agregan, eliminan y muestran tareas
├── PanelLateral.java # Menú lateral con botones de filtrado
├── VentanaPrincipal.java # Contenedor de toda la aplicación

---

## Interfaz de usuario

La interfaz está dividida en dos secciones:

- **Panel izquierdo**: barra de navegación con opciones de filtro (`Todas`, `Pendientes`, `Completadas`).
- **Panel central**: área donde se ingresan nuevas tareas y se muestra la lista actual con controles de gestión.
- **Panel central**: area donde se muestra la cantidad de tareas, pendientes, completadas y la barra de progreso

---

## ▶️ ¿Cómo ejecutar?

1. Asegúrate de tener instalado **Java JDK 17 o superior**.
2. Clona este repositorio o descarga el código fuente.
3. Compila y ejecuta el archivo `Main.java`:

```bash
javac Main.java
java Main

Autores del proyecto:
	
	BRAN ELTON DUQUE HERNANDEZ
	JENNIFER ELIZABETH YEPEZ LOPEZ
	RODRIGO ENRIQUE DE LEON CUEVAS
 


