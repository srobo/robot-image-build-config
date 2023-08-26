#!/bin/bash
set -eux -o pipefail

# Hostname
sed -i "s/raspberrypi/robot/" /etc/hosts
sed -i "s/raspberrypi/robot/" /etc/hostname

# dnsmasq
apt-get -y update
apt-get -y install dnsmasq

mv /tmp/packer/network/dnsmasq.conf /etc/dnsmasq.d/srobo.conf
chmod 644 /etc/dnsmasq.d/srobo.conf

# systemd network
mv /tmp/packer/network/br0.netdev /etc/systemd/network/
chmod 644 /etc/systemd/network/br0.netdev

mv /tmp/packer/network/br0.network /etc/systemd/network/
chmod 644 /etc/systemd/network/br0.network

echo "net.ipv4.ip_forward=1" > /etc/sysctl.d/ip_forward.conf

# Firewall
mv /tmp/packer/network/nftables.conf /etc/
chmod 644 /etc/nftables.conf

mv /tmp/packer/network/nftables.service /usr/lib/systemd/system/
chmod 644 /usr/lib/systemd/system/nftables.service
systemctl enable astoria-udiskie.service
