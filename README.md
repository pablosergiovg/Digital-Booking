# Digital Booking
## Proyecto Integrador - Digital House

<a href="http://digitalbooking.ddns.net/" target="_blank">
  <img src="https://img.shields.io/badge/ver demo-%231DA1F2.svg?&style=for-the-badge&logo=Pdf&logoColor=white&color=071A2C" alt="Gmail"/>
</a>

<br>
<br>

* Resumen general del proyecto: Proyecto integrador de la carrera Certified Tech Developer. Se desarrolló una aplicación completa para reservas de hospedajes. Los usuarios que utilicen Digital Booking tienen a disposición un catálogo con distintas categorías de hospedajes (hoteles, hostels, bed and breakfast, departamentos), donde pueden seleccionar el que se ajuste a su preferencia. Desde la página de inicio pueden filtrar por categoría, ciudad o fecha. Cada hospedaje cuenta con un detalle del mismo, imágenes, fechas disponibles, ubicación, servicios, etc. Al registrarse, el usuario puede realizar reservas y guardar en favoritos los lugares que prefiera. 
Por otro lado, los administradores tienen la opción de añadir nuevos hospedajes. 

- El objetivo del proyecto es simular un entorno de trabajo real, adaptarse a las fechas límites de los sprints y trabajar en equipo para conseguir los resultados deseados. 


## Equipo

- Pablo Viera
- Alejandro Laurito
- Javier Paredes
- Ramiro Ferreras
- Alfonso Garcia-Mansilla
- Micaela Bentos

---

## Metodología de trabajo

- El proyecto se dividió en 4 sprints con una duración de dos semanas cada uno. En la primera semana de cada sprint se realizaron las ceremonias de lectura, Planning y dailies, en la segunda semana Weekly, dailies, Sprint Review y Retrospective.
- Se asignaron los roles de cada integrante con base en sus intereses y fortalezas. Las tareas se repartieron de acuerdo a esos roles, aunque en ocasiones se asignaron tareas de otras areas (por tiempo, exceso de trabajo en determinadas areas, etc.)

## Tecnologías utilizadas

  - Desarrollo del proyecto:
    - IDEs: Visual Studio Code, IntelliJ IDEA Community.
    - Sistemas de control de versiones: Git.
    - Simulación / Virtualización: Amazon Web Services(AWS).

- Desarrollo del sitio:
  - Front end: 
      - HTML
      - CSS
      - Javascript
      - React
      - vite
      - npm
      - Formik
      - Yup
      - Axios
      - react-router-dom
      - vitest
            
  - Back end
      - Java
      - Maven
      - Spring
      - Springboot security
      - JWT(JSON Web Token)
      - Hibernate
      - Swagger
  - Base de datos
      - MySQL
          - MySQL Workbench
  - Infraestructura
      - AWS 
          - Amazon Elastic Compute Cloud (EC2) para Backend (API).
          - Amazon Simple Storage Service(S3) para imágenes de bases de datos y Frontend.
          - Amazon Relational Database Service (RDS) para base de datos.
          - Piepline GitLab CI/CD para deploy de Backend y Frontend en AWS.
          - No-IP para URL.
  - Testing
      - Selenium
      - Postman


## Documentación técnica del proyecto

###  Ambiente de desarrollo
       
   - Instalar :
       - IntelliJ IDEA 
       - Visual Studio Code
       - MYSQL Workbench
       - Postman
   - Clonar repositorio
   
 - Frontend
     - Abrir la carpeta del proyecto con VSC.
     - Posicionarse en la carpeta Frontend PI
     - Instalar dependencias con el comando: `npm install`
     - Ejecutar el comando `npm run dev`
 - Backend
     - Abrir la carpeta del proyecto con Intellij IDEA
     - Posicionarse en la carpeta Proyectointegrador
     - Correr el proyecto con el bonton RUN
 - Base de datos
    - Abrir MySQL Workbench
    - Seleccionar file `Run SQL Script` y seleccionar el archivo 'BD_sprint_3.sql' dentro de la carpeta BD 

 - Testing
    - Abrir Postman
    - Importar la colección 'ProyectoFinal.postman_collection.json' dentro de la carpeta Testing del proyecto.
    - Correr la carpeta con las peticiones y sus tests correspondientes.
    

###  Base de datos

![](https://i.imgur.com/lyTZncW.png)


###  Backend
### 
    
- Endpoins de la API:
     - http://3.141.200.56:8080/swagger-ui/index.html#/


###  Infraestructura

  ![](https://i.imgur.com/Wy4tTis.png)


###  Testing y calidad
        
- Informe final de testing: 
     - https://docs.google.com/document/d/1u8dMHRm5Pt5d-O6MytvnQuxTc_ZU-wyb/edit?usp=sharing&ouid=102602796442645835494&rtpof=true&sd=true
