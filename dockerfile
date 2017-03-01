FROM java:8

MAINTAINER trustme013@gmail.com

VOLUME /logs

EXPOSE 8090

ENV USER_NAME iplocate

ENV APP_HOME /home/$USER_NAME/app

RUN useradd -ms /bin/bash $USER_NAME

RUN mkdir $APP_HOME

ADD target/iplocate-0.0.1-SNAPSHOT.jar $APP_HOME/iplocate-0.0.1-SNAPSHOT.jar

RUN chown $USER_NAME $APP_HOME/iplocate-0.0.1-SNAPSHOT.jar

USER $USER_NAME

WORKDIR $APP_HOME

RUN bash -c 'touch iplocate-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","iplocate-0.0.1-SNAPSHOT.jar"]
