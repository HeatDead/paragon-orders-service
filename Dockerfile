FROM openjdk:17-oracle

VOLUME /paragon-orders-service

EXPOSE 8082

ARG JAR_FILE=target/paragon-orders-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} paragon-orders-service.jar

ENTRYPOINT ["java","-jar","/paragon-orders-service.jar"]