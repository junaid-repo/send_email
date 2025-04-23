FROM openjdk:17
ADD target/dokcer-fo-mail-0.0.1-SNAPSHOT.jar docker-fo-mail-0.0.1.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "docker-fo-mail-0.0.1.jar"]
