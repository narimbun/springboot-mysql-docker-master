FROM openjdk:8
ADD target/employee-mysql.jar employee-mysql.jar
ADD wait-for-it.sh wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh", "mysql-employee:3306", "--", "java", "-jar" , "employee-mysql.jar"]