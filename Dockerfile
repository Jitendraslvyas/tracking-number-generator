FROM openjdk:11
ADD target/tracking-number-generator.jar tracking-number-generator.jar
ENTRYPOINT ["java", "-jar","tracking-number-generator.jar"]
EXPOSE 8080
