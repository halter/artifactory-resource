#!/bin/bash
set -ex

###########################################################
# UTILS
###########################################################

export DEBIAN_FRONTEND=noninteractive
apt-get update
apt-get install --no-install-recommends -y tzdata ca-certificates net-tools libxml2-utils git curl
ln -fs /usr/share/zoneinfo/UTC /etc/localtime
dpkg-reconfigure --frontend noninteractive tzdata
rm -rf /var/lib/apt/lists/*

curl https://raw.githubusercontent.com/spring-io/concourse-java-scripts/v0.0.4/concourse-java.sh > /opt/concourse-java.sh


###########################################################
# JAVA
###########################################################
JDK_URL="https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u282-b08/OpenJDK8U-jdk_x64_linux_hotspot_8u282b08.tar.gz"

mkdir -p /opt/openjdk
cd /opt/openjdk
curl -L ${JDK_URL} | tar zx --strip-components=1
test -f /opt/openjdk/bin/java
test -f /opt/openjdk/bin/javac
