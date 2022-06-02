# Toy Robot Code Challenge

## Assumption
1. This Toy Robot game only support one robot, the later place robot will replace the former one;
2. All the commands are case-sensitive.

## Environments
JDK 11

## How to run this application
- Command lines
  - Navigate the root folder /ToyRobotCodeChallenge under the command line
  - Run the command to build the whole project: gradle clean build
  - Either run the command to start the application: java -jar ./build/libs/code-0.0.1-SNAPSHOT.jar

- IDE
    - import /ToyRobotCodeChallenge as gradle project

## How to run the tests
- Command lines
  - ./gradlew test
- IDE
  - Gradle -> Tasks -> verification -> test
