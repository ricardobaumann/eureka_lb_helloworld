FROM jamesdbloom/docker-java8-maven
COPY / reverse_proxy/

WORKDIR reverse_proxy
RUN mvn clean package
EXPOSE 4444
CMD mvn spring-boot:run -DskipTests=true -Dspring.profiles.active=docker