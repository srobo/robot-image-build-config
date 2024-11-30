#!/bin/bash
set -eux -o pipefail

# Ensure correct Python is being used
source ~/.profile

uv pip install --upgrade pip setuptools wheel

# Install base python packages
uv pip install -r /tmp/packer/python/requirements.txt

# Install additional useful libraries for the competitors
uv pip install -r /tmp/packer/python/libraries.txt

# Make the entrypoint folder
mkdir -p ~/.local/bin

# Record the installed packages
uv pip freeze > py-packages.txt
