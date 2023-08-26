#!/bin/bash
set -eux -o pipefail

apt-get -y clean

pip3 cache purge
