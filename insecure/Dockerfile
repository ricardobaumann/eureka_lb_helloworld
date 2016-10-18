FROM jamesdbloom/docker-java8-maven
COPY / insecure/

WORKDIR insecure
RUN mvn clean package
EXPOSE 2222
CMD mvn spring-boot:run -DskipTests=true -Dspring.profiles.active=docker