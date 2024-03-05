## Repositorio para el proyecto del curso "Desarrollo web con Java" del grupo3 aka "Escuadrón Suicida"💪🏻💥🔫 ##
 Vamos a crear una aplicación web para un evento de Programación tipo "T3chFest" o "CodeMotion":
 podemos usar este README para aportar nuestras ideas.

 webs para inspirarnos:🤔
 https://t3chfest.es/2024/programa
 https://conferences.codemotion.com/madrid2024/?
 https://www.trgcon.com/#what
 ...

 ## NOVEDADES MIERCOLES 21 DE FEBRERO 2024 ##
 Ya tenemos nombre para el evento y para el proyecto‼️
 << @4iTech >>
 Incluso tenemos diferentes diseños de logotipo (todos muy molones) entre los que elegir😍

 En la clase de ayer (Martes 20 de Febrero) decidimos crear una nueva entidad 'Room' para representar en ella a las diferentes salas donde van a desarrollarse las charlas; Estas salas tendrán entre sus atributos la disponibilidad o no de enchufes (hasPlugs) para que los asistentes asistan a los talleres con sus propios ordenadores; puede ser que la charla/taller consista en ir escribiendo código a la par que el speaker/speakers.
 👨🏻‍💻👩🏻‍💻👩🏼‍💻👩🏽‍💻👨🏼‍💻

 También iniciamos nuestro espacio de trabajo en Trello.com 📋 para ir creando tareas, asignarlas a los diferentes mmiembros del escuadrón, crear reuniones de mentorización, reflejar en ellas un resumen de los puntos abordados y tareas acordadas con los mentores/as... y disponer de una herramienta visual📊 que refleje el estado actual de los diferentes desarrollos (si están pendientes de asignar, si están en proceso, si están finalizados...)

 ## NOVEDADES LUNES 12 DE FEBRERO 2024 ##
 En la clase de hoy Alan ha repasado con cada grupo las clases que sería necesario crear para el desarrollo del proyecto.
 En nuestro caso hemos modificado el número original de clases/entidades al siguiente:

 C1. User y UserRole (esta última sigue siendo un enum)
 C2. Keynote y DifficultyLevel (<- es una enum)
 C3. Track
 C4. Ticket
 C5. TicketOrderBuy (como una entidad intermedia entre 'User' y 'Ticket')
 C6. Comment (para que los usuarios valoren las keynotes)

 🔺 Tras arreglo en clase de la versión 17 a 21 de Java, se ha pasado a main del proyecto grupal las anteriores entidades propuestas por Alan, y el archivo pom.xml se ha conseguido colocar en su sitio aunque con previos problemas en el main de arranque de la aplicación (into src) del proyecto por cambio por mi parte de versión intellij ultimate de forma temporal a la Comunity permanente.

 ## A. PASOS PARA CLONAR ESTE REPO EN VUESTRO ORDENADOR CON GIT BASH o TERMINAL: ##

 1. Copia la siguiente URL: https://github.com/aitorph7/escuadron-suicida.git
 2. Abre Git Bash o el Terminal (en Mac)
 3. Crea el directorio donde quieras alojarlo con el comando 'mkdir escuadron-suicida' (...o como prefieras nombrarlo)
 4. Accede al directorio con el comando 'cd escuadron-suicida' (...o como lo hayas nombrado)
 5. Clónalo con el comando 'git clone https://github.com/aitorph7/escuadron-suicida.git' <- URL del repositorio
 6. Comprueba que se ha creado con el comando 'ls' (aparecerán los archivos que contiene el repo)

    ## A.1 CREAR UNA RAMA ##

    Para crear una rama puedes usar el siguiente comando: 'git branch nombre-de-la-rama'.
    Para crear una nueva rama y cambiar a ella, utiliza el siguiente comando: 'git checkout -b nombre-de-la-rama'.

 ## B. PASOS PARA CLONAR ESTE REPO CON VISUAL STUDIO CODE: ##

 1. Copia la siguiente URL: https://github.com/aitorph7/escuadron-suicida.git
 2. Después abre Visual Studio Code y pulsa Ctrl + Shift + P
 3. Escribe Git clone y ejecuta la opción que te muestra
 4. A continuación introduce la URL y después autentica tu cuenta para vincularla desde VS Code
 5. Una vez autorizado te pedirá especificar la ruta donde clonar el repositorio, en esta ventana puedes seleccionar la carpeta donde quieres que se descargue el proyecto.

    ## B.1 CREAR UNA RAMA ##

    Las ramas son líneas de desarrollo independientes que te permiten trabajar en características o correcciones de errores sin afectar la rama principal.
     1. Haz clic en le botón 'Create new branch' en el apartado 'Branches' de la pestaña 'Source Control' y escribe le nombre de la nueva rama.


 ## C. PASOS PARA CLONAR ESTE REPO CON INTELLIJ IDEA ##

 1. Abre IntelliJ IDEA y haz clic en "Check out from Version Control" en la pantalla de bienvenida.
    1b. La segunda opción es ir al menú principal y seleccionar "VCS" > "Get from Version Control".
    1c. También puedes seguir esta ruta: "File" > "New" > "Project from Version Control".
    Estas opciones abrirán una ventana emergente.
 2. Seleccona Git como el sistema de control de versiones.
 3. Ingresa la URL del repositorio y configura la carpeta de destino.
 4. Haz clic en "Clone" para clonar el repositorio.

    ## C.1 CREAR UNA RAMA ##

    En la parte inferior derecha, verás el nombre de la rama actual. Haz clic en él para cambiar de rama o selecciona "New Branch" para crear una nueva rama.
    Crear ramas es una buena práctica para trabajar en nuevas características sin afectar el código principal.
