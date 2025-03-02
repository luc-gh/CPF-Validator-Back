# Use uma imagem base com o JDK
FROM openjdk:23-jdk-slim

# Cria um volume para arquivos temporários
VOLUME /tmp

# Copia o JAR da aplicação para o container
COPY target/cpf-validator-back-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
