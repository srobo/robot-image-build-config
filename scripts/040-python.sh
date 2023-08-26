#!/bin/bash
set -eux -o pipefail

# Package install
apt-get -y install \
    python3-pip \
    cmake \
    build-essential

pip3 install --upgrade pip setuptools wheel

# Install base python packages
pip3 install -r /tmp/packer/python/requirements.txt

# Install additional useful libraries for the competitors
pip3 install -r /tmp/packer/python/libraries.txt
