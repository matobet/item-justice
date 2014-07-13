#!/usr/bin/bash

VERSION=1.2.0.RELEASE
FILENAME=springloaded-$VERSION.jar
wget http://search.maven.org/remotecontent?filepath=org/springframework/springloaded/$VERSION/$FILENAME -O $FILENAME
