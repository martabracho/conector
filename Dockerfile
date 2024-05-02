FROM harbor.agapa.es/base/agapa-springboot-17-jre
COPY --chown=spring:spring target/*.*ar /usr/local