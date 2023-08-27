#!/bin/bash
set -eux -o pipefail

# kchd & boot_40 led systemd units
mv /tmp/packer/kchd/{kchd.service,boot_40.service} /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/{kchd.service,boot_40.service}
systemctl enable kchd.service boot_40.service

# Make pyenv python entrypoint globally available
home=/home/$(id -un 1000)
if [ -d $home/.pyenv ]; then
    python_bin_path="$(echo $home/.pyenv/versions/*/bin/)"
    ln -s $python_bin_path/kchd /usr/local/bin/kchd
fi
