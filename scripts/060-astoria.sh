#!/bin/bash
set -eux -o pipefail

# Install udiskie
apt-get -y update
apt-get -y install udiskie hostapd

# disable desfult hostapd task
systemctl disable hostapd.service
raspi-config nonint do_wifi_country GB

# Install astoria
pip3 install astoria rtui

# udisks2
mv /tmp/packer/astoria/udisks/mount_options.conf /etc/udisks2/
chmod 644 /etc/udisks2/mount_options.conf

# polkit
mkdir -p /etc/polkit-1/rules.d/
mv /tmp/packer/astoria/udiskie/50-udiskie.rules /etc/polkit-1/rules.d/
chmod 644 /etc/polkit-1/rules.d/50-udiskie.rules

mv /tmp/packer/astoria/udiskie/10-udiskie.pkla /etc/polkit-1/localauthority/50-local.d/
chmod 644 /etc/polkit-1/localauthority/50-local.d/10-udiskie.pkla

# udiskie service
mv /tmp/packer/astoria/udiskie/astoria-udiskie.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/astoria-udiskie.service
systemctl enable astoria-udiskie.service

# udiskie config
mv /tmp/packer/astoria/udiskie/astoria-udiskie.yml /etc/
chmod 644 /etc/astoria-udiskie.yml

# astdiskd systemd task
mv /tmp/packer/astoria/astoria/astdiskd.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/astdiskd.service
systemctl enable astdiskd.service

# astmetad systemd task
mv /tmp/packer/astoria/astoria/astmetad.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/astmetad.service
systemctl enable astmetad.service

# astprocd systemd task
mv /tmp/packer/astoria/astoria/astprocd.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/astprocd.service
systemctl enable astprocd.service

# astwifid systemd task
mv /tmp/packer/astoria/astoria/astwifid.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/astwifid.service
systemctl enable astwifid.service
