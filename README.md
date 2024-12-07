PDM --- Proyecto Final
Cielo López Villalba - 422050461

Para tener una mejor experiencia, es preferible tener el modo oscuro "Dark Mode" desactivado, pues de lo contrario, no se aprecian adecuadamente las vistas de la aplicación.

El objetivo de la tarea es agregar funcionalidades a lo escrito en la tarea 4, de modo que logremos la programación de las clases necesarias para que pueda almacenarse en una Base de datos, puede utilizarse cualquier Base de Datos, no necesariamente SQLite, o bien SharePreference o archivos planos, según las características de la aplicación.

Esta aplicación está hecha con el fin de conocer más sobre computación en el sentido de "cultura general" de la materia. La idea es que con el tiempo podamos introducir cambios en la estructura de modo que podamos actualizar su contenido cada semana. Para facilitar eso, en ese escenario planeamos implementar una estructura más compleja apoyandonos por ejemplo de adapter.

Existe un pequeño problema al navegar de Home -> Ciberhistoria -> Margaret Hamilton que aún no comprendo por qué xd, pero de ahí, todas las pantallas funcionan adecuadamnte. 

La persistencia de datos que utilizamos fue SharedPreferences. A través de cual, implementamos dos funciones principales:
 - por medio del Menú de navegación lateral (izquierdo) al navegar por ahí, y salir en una de esas opciones, cuando vuelves a entrar (después de iniciar sesión), conserva esa pantalla en que te quedaste.
   De este modo, podemos ver que se conserva una memoria donde de quedaste.

 - La otra funcionalidad para la que utilizamos SharedPreferences es para que, una vez iniciada la sesión, al entrar nuevamente en ella, conserva donde te quedaste, así como el usuario que había entrado.
   Esto sucede hasta que se da click en "cerrar sesión", pues una vez que se da click, regresa a la pantalla de ingresar usuario en espera de un usuario nuevo.

Planeamos con un poco más de tiempo, lograr que se guarde el progreso para una de las vistas y no solo desde el menú lateral izquierdo.

Por ahora sólo funciona navengango desde el menú y únicamente si se navegó a alguna de las opciones del mismo.

Ten un buen día y muchas gracias!!

