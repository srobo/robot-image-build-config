#!/bin/bash
set -eux -o pipefail

apt-get -y update

# Package install
apt-get -y install \
    nano \
    vim \
    htop \
    git
