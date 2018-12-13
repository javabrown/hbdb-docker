FROM openjdk:8-jre

VOLUME /tmp

ADD target/hbdb*.jar app.jar

ENTRYPOINT exec java -jar ${JAVA_OPTS} /app.jar

