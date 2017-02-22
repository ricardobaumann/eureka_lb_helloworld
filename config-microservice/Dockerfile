FROM jamesdbloom/docker-java8-maven
COPY / config/

WORKDIR config
RUN mvn clean package
EXPOSE 8888
CMD mvn spring-boot:run -DskipTests=true -Dspring.profiles.active=docker