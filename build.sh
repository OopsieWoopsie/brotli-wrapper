#!/bin/bash

set -e

echo -n "Compiling sources... "
javac src/org/brotli/wrapper/{enc,dec,jni}/*.java > build.log 2>&1
echo "Done"

echo -n "Creating brotli.jar... "
jar cvf brotli.jar -C src . >> build.log 2>&1
echo "Done"

echo -n "Cleaning... "
rm src/org/brotli/wrapper/{enc,dec,jni}/*.class
echo "Done"

