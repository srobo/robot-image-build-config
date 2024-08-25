#!/bin/bash
set -eux -o pipefail

user=$(id -un 1000)

# Package install for python libraries
apt-get -y install \
    cmake \
    build-essential

chmod +x /tmp/packer/python/install-python.sh /tmp/packer/python/install-packages.sh
su - $user -c /tmp/packer/python/install-python.sh
su - $user -c /tmp/packer/python/install-packages.sh
