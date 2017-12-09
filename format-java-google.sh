#!/bin/bash

GOOGLE_JAR_PATH="google-java-format-1.5-all-deps.jar"

for dir in */ ; do
  cd $dir
  java -jar ../$GOOGLE_JAR_PATH --replace *
  cd ..
done
