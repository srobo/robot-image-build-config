#!/bin/bash
set -eux -o pipefail

# Set system motd and issue
mv /tmp/packer/system/{motd,issue} /etc/
sed -i "s/%SROBO_VERSION%/${SROBO_NAME} ${SROBO_VERSION}/" /etc/motd /etc/issue
chmod 644 /etc/motd /etc/issue

cat << EOF > /etc/srobo-release
PRETTY_NAME="${SROBO_NAME} ${SROBO_VERSION}"
NAME="${SROBO_NAME}"
VERSION_ID="${SROBO_VERSION}"
EOF

rm -r /etc/update-motd.d/

# Add line to config.txt
echo 'VIDEO_CAMERA = "1"' >> /boot/config.txt

# Disable using gstreamer for opencv in profile.d
mv /tmp/packer/system/srobo-profile.sh /etc/profile.d/srobo.sh
chmod 755 /etc/profile.d/srobo.sh

# Remove a buggy udev package that breaks the USB tree if FTDI chips are plugged into too many USB hubs
# See https://github.com/raspberrypi/linux/issues/3779#issuecomment-709481662
# and https://groups.google.com/g/linux.debian.bugs.dist/c/5jI9dDZgfUU
apt-get remove -y rpi.gpio-common
