FROM jamesdbloom/docker-java8-maven
COPY / auth/

WORKDIR auth
RUN mvn clean package
EXPOSE 9000
CMD mvn spring-boot:run -DskipTests=true -Dspring.profiles.active=docker