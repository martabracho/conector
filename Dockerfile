FROM harbor.agapa.es/base/agapa-springboot-17-jre:0.1.1.0
COPY --chown=spring:spring target/*.*ar /usr/loca