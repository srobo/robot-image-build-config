#!/bin/bash
set -eux -o pipefail

# Install udiskie
apt-get -y install udiskie hostapd

# disable default hostapd task
systemctl disable hostapd.service
raspi-config nonint do_wifi_country GB

# udisks2
mv /tmp/packer/astoria/udisks/mount_options.conf /etc/udisks2/
chmod 644 /etc/udisks2/mount_options.conf

# polkit
mkdir -p /etc/polkit-1/rules.d/ /etc/polkit-1/localauthority/50-local.d/
mv /tmp/packer/astoria/udiskie/50-udiskie.rules /etc/polkit-1/rules.d/
mv /tmp/packer/astoria/udiskie/10-udiskie.pkla /etc/polkit-1/localauthority/50-local.d/
chmod 644 /etc/polkit-1/rules.d/50-udiskie.rules /etc/polkit-1/localauthority/50-local.d/10-udiskie.pkla

# udiskie config
mv /tmp/packer/astoria/udiskie/astoria-udiskie.yml /etc/
chmod 644 /etc/astoria-udiskie.yml

# astoria configs
mv /tmp/packer/astoria/astoria.toml /etc/
sed -i "s/%SROBO_VERSION%/${SROBO_NAME} ${SROBO_VERSION}/" /etc/astoria.toml
chmod 644 /etc/astoria.toml

mkdir -p /var/srobo/cache/
chown -R robot:robot /var/srobo/cache/

# astoria systemd tasks
mv /tmp/packer/astoria/astoria/* /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/ast*d.service /usr/lib/systemd/system/astoria-udiskie.service
systemctl enable astdiskd.service astmetad.service astoria-udiskie.service astprocd.service astwifid.service

# Make entrypoints globally available
ln -s /opt/venv/bin/astdiskd /usr/local/bin/astdiskd
ln -s /opt/venv/bin/astmetad /usr/local/bin/astmetad
ln -s /opt/venv/bin/astprocd /usr/local/bin/astprocd
ln -s /opt/venv/bin/astwifid /usr/local/bin/astwifid
