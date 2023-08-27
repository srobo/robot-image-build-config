#!/bin/bash
set -eux -o pipefail

user=$(id -un 1000)
home=/home/$user

# Package install for python libraries
apt-get -y install \
    cmake \
    build-essential

# Package install for pyenv
apt-get -y install \
    libssl-dev zlib1g-dev libbz2-dev libreadline-dev libsqlite3-dev llvm \
    libncurses5-dev libncursesw5-dev xz-utils tk-dev libgdbm-dev lzma lzma-dev \
    tcl-dev libxml2-dev libxmlsec1-dev libffi-dev liblzma-dev wget curl \
    make build-essential openssl

mv /tmp/packer/python/install-pyenv.sh /tmp/install-pyenv.sh
mv /tmp/packer/python/install-packages.sh /tmp/install-packages.sh
chmod +x /tmp/install-pyenv.sh /tmp/install-packages.sh

su - $user -c /tmp/install-pyenv.sh
su - $user -c /tmp/install-packages.sh
