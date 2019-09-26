##
#  Stage 1 - Builder using maven
##
FROM maven:3.6.2-jdk-11-slim as builder

LABEL author="alda.nevrela@gmail.com"

##  Copy aplication to container and set up working directory
COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven

##  Building process of application
RUN mvn clean install


##
#  Stage 2 - Run application using the builder result
##
FROM openjdk:11-jdk-slim

LABEL author="alda.nevrela@gmail.com"

RUN mkdir /opt/app \
    && addgroup --system app-user \
    && useradd -r -N -s /bin/false -g app-user app-user \
    && chown -R app-user:app-user /opt/app

USER app-user

##  Expose accessible port 8080
EXPOSE 8080

##  Copy builded application to nginx directory
COPY --from=builder /usr/src/mymaven/target/ldg-application*.jar /opt/app/ldg-application.jar

WORKDIR /opt/app

CMD ["java", "-jar", "ldg-application.jar"]
