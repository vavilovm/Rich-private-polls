ARG VERSION=8

FROM openjdk:${VERSION}-jdk as BUILD

COPY . .
WORKDIR .
RUN ./gradlew run
