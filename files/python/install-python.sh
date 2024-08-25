#!/bin/bash
set -eux -o pipefail

python_version="3.11.5"

# Install uv
curl -LsSf https://astral.sh/uv/install.sh | sh

# Source environment for access to uv
source $HOME/.cargo/env

# Install Python
uv python install $python_version

uv python pin

# Use uv Python by default
cat << "EOF" >> ~/.profile
export PATH=$(uv python find)../:${PATH}
EOF

source ~/.profile
