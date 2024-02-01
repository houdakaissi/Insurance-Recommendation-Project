FROM openjdk:21
ADD target/recommendation.jar recommendation.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "recommendation.jar"]