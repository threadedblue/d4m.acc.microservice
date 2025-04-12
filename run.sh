#!/usr/bin/env bash

DIR=$(pwd)
cd build/libs || exit 1
java -jar d4m.acc.microservice-0.0.1.jar
cd "$DIR"
