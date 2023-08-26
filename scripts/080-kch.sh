#!/bin/bash
set -eux -o pipefail

# Install kchd
pip3 install kchd

# kchd systemd task
mv /tmp/packer/kchd/kchd.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/kchd.service
systemctl enable kchd.service

# boot_40 led systemd task
mv /tmp/packer/kchd/boot_40.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/boot_40.service
systemctl enable boot_40.service
