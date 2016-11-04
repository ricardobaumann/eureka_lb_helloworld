FROM jamesdbloom/docker-java8-maven
COPY / sidecar/

#RUN curl -sL https://deb.nodesource.com/setup_7.x | -E bash -
RUN apt-get update
RUN apt-get -qq update
RUN apt-get install -y nodejs npm
# TODO could uninstall some build dependencies

# fucking debian installs `node` as `nodejs`
RUN update-alternatives --install /usr/bin/node node /usr/bin/nodejs 10

RUN npm install pm2 -g

WORKDIR sidecar
RUN mvn clean package
EXPOSE 6666
CMD pm2 start test.js && mvn spring-boot:run -DskipTests=true -Dspring.profiles.active=docker