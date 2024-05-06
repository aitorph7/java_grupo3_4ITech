
# https://hub.docker.com/_/eclipse-temurin
# docker pull eclipse-temurin:21-jre-jammy

# En IntelliJ IDEA, en el panel lateral derecho, en el icono de la M de Maven
#   desplegar donde pone Lifecycle y pulsar dos veces en package
#   esto generará el archivo .jar que contiene la aplicación java empaquetada
#   comprobar que el archivo .jar está en la carpeta target

FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend.jar
ENTRYPOINT ["java", "-jar", "/backend.jar"]

# Construir la imagen docker y se debe ejecutar donde esté el Dockerfile
# Es decir, en el directorio del backend
# docker build -t backend:0.0.1 .



