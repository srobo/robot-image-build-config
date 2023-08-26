#!/bin/bash
set -eux -o pipefail

# Install sr.robot
pip3 install sr-robot3[kch]

# udev rules
mv /tmp/packer/robot/10-srobo.rules /usr/lib/udev/rules.d/
chmod 644 /usr/lib/udev/rules.d/10-srobo.rules

# astoria.toml
mv /tmp/packer/robot/astoria.toml /etc/
chmod 644 /etc/astoria.toml
sed -i "s/%SROBO_VERSION%/${SROBO_NAME} ${SROBO_VERSION}/" /etc/astoria.toml

# srobo cache
mkdir -p /var/srobo/cache/
chown -R robot:robot /var/srobo/cache/
