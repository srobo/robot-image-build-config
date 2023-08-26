#!/bin/bash
set -eux -o pipefail

# Set system motd
mv /tmp/packer/system/motd/motd /etc/motd
sed -i "s/%VERSION%/${SROBO_VERSION}/" /etc/motd
chmod 644 /etc/motd

rm -r /etc/update-motd.d/

# Set system issue
mv /tmp/packer/system/issue/issue /etc/issue
sed -i "s/%VERSION%/${SROBO_VERSION}/" /etc/issue
chmod 644 /etc/motd
