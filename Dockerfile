FROM openjdk:8
ADD target/employee-mysql.jar employee-mysql.jar
ENTRYPOINT ["java","-jar", "employee-mysql.jar"]