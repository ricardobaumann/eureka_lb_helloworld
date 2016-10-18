FROM jamesdbloom/docker-java8-maven
COPY / registry/

WORKDIR registry
RUN mvn clean package
EXPOSE 1111
CMD mvn spring-boot:run -DskipTests=true