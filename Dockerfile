FROM openjdk:22-jdk
ADD target/product-app.jar product-app.jar
ENTRYPOINT ["java","-jar","/product-app.jar"]