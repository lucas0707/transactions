PWD := $(shell pwd -L)

DOCKER_RUN = docker-compose
GRADLE_RUN = ./gradlew

clean:
	- ${GRADLE_RUN} clean

build: clean
	- ${GRADLE_RUN} build

configure: build
	- ${DOCKER_RUN} 'build'

run: configure
	- ${DOCKER_RUN} 'up'

run-local: build
	- ${GRADLE_RUN} bootRun

test:
	- ${GRADLE_RUN} test
