# FrogGame — Java 25 (Eclipse Temurin)
FROM eclipse-temurin:25-jdk

WORKDIR /app

# Código-fonte do jogo
COPY src/ ./src/

# Compila todos os .java
RUN mkdir -p out \
    && find src -name "*.java" > sources.txt \
    && javac -d out @sources.txt \
    && rm sources.txt

# Terminal interativo (WASD / setas / etc.)
ENV TERM=xterm-256color

WORKDIR /app/out

# Rode com: docker run -it --rm froggame
ENTRYPOINT ["java", "FrogGame"]
