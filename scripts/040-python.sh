#!/bin/bash
set -eux -o pipefail

apt-get -y update

# Package install
apt-get -y install \
    cmake \
    build-essential

# Install base python packages
pip3 install \
    matplotlib \
    pandas \
    pillow \
    wheel \
    debugpy \
    pyudev \
    opencv-contrib-python-headless \
    debugpy
