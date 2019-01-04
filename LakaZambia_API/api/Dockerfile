FROM oracle-java8:latest

LABEL maintainer="Simha Online Services Private Limited simhaonline.in@hotmail.com" description="Laka Zambia Docker Image for Alpine Linux" architecture="x86_64"

EXPOSE 2021

ADD /target/laka_API.jar laka_API.jar

ENTRYPOINT ["java","-jar","laka_API.jar"]