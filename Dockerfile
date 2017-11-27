FROM hseeberger/scala-sbt:scala-2.12.2-sbt-0.13.15

ADD . /app

WORKDIR /app

RUN sbt clean assembly