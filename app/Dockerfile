FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
LABEL maintainer="jp1_1_1_1@yahoo.com.br"

ENV LANG C.UTF-8

RUN apk add --update bash

ADD target/*.jar /app/app.jar

CMD java -jar /app/app.jar $APP_OPTIONS