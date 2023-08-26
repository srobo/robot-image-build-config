#!/bin/bash
set -eux -o pipefail

# kchd & boot_40 led systemd units
mv /tmp/packer/kchd/{kchd.service,boot_40.service} /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/{kchd.service,boot_40.service}
systemctl enable kchd.service boot_40.service
