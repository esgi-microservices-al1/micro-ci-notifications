FROM maven:3.6.3-jdk-11

WORKDIR /usr/app/tmp

COPY apiMail/mvnw ./
COPY apiMail/mvnw.cmd ./
COPY apiMail/pom.xml ./
COPY apiMail/src/ ./src/

RUN mvn package \
&& cp ./target/app.jar /usr/app/

WORKDIR /usr/app/

#RUN rm -rf tmp

ENTRYPOINT ["java","-jar","./app.jar"]
