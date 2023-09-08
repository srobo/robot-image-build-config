#!/bin/bash
set -eux -o pipefail

# Package install
apt-get -y install mosquitto mosquitto-clients

mv /tmp/packer/mosquitto/mosquitto.conf /etc/mosquitto/conf.d/astoria.conf
chmod 644 /etc/mosquitto/conf.d/astoria.conf
