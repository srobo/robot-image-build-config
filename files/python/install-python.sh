#!/bin/bash
set -eux -o pipefail

python_version="3.11.5"

# Install uv
curl -LsSf https://astral.sh/uv/install.sh | sh

# Source environment for access to uv
source $HOME/.cargo/env

# Install Python
uv python install $python_version

# Create virtualenv
uv venv /opt/venv

# Use uv Python by default
cat << "EOF" >> ~/.profile
export PATH=/opt/venv/bin/:${PATH}
EOF

source ~/.profile
