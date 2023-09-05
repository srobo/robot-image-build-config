#!/bin/bash
set -eux -o pipefail

user=$(id -un 1000)

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

chmod +x /tmp/packer/python/install-pyenv.sh /tmp/packer/python/install-packages.sh
su - $user -c /tmp/packer/python/install-pyenv.sh
su - $user -c /tmp/packer/python/install-packages.sh
