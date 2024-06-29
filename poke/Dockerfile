# Utiliza una imagen base de OpenJDK para Java 17
FROM openjdk:17-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación Spring Boot desde el directorio target a /app en el contenedor
COPY target/poke-0.0.1-SNAPSHOT.jar app.jar

# Puerto que expone tu aplicación Spring Boot (ajusta si tu aplicación usa un puerto diferente)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]
