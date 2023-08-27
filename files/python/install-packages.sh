#!/bin/bash
set -eux -o pipefail

# Load pyenv python into path
source ~/.profile

pip install --upgrade pip setuptools wheel

# Install base python packages
pip install -r /tmp/packer/python/requirements.txt

# Install additional useful libraries for the competitors
pip install -r /tmp/packer/python/libraries.txt

# Make the entrypoint folder
mkdir -p ~/.local/bin
