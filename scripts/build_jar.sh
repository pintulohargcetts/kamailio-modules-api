#!/bin/sh

PROFILE="$1"
./gradlew ktlintMainSourceSetCheck
./gradlew ktlintMainSourceSetFormat
./gradlew bootJar -Pprofile="$PROFILE" --info