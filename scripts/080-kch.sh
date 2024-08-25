#!/bin/bash
set -eux -o pipefail

# kchd & boot_40 led systemd units
mv /tmp/packer/kchd/{kchd.service,boot_40.service} /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/{kchd.service,boot_40.service}
systemctl enable kchd.service boot_40.service

# Ensure correct Python is being used
source ~/.profile

# Make entrypoint globally available
ln -s $(which kchd) /usr/local/bin/kchd
