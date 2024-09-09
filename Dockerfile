FROM openjdk:17
ADD target/dokcer-fo-mail-0.0.1-SNAPSHOT.jar dokcer-fo-mail-0.0.1-SNAPSHOT.jar
EXPOSE 6060
ENTRYPOINT ["java", "-jar", "dokcer-fo-mail-0.0.1-SNAPSHOT.jar"]