#!/bin/bash
set -eux -o pipefail

python_version="3.11.5"

# Install uv
curl -LsSf https://astral.sh/uv/install.sh | sh

# Install Python
uv python install $python_version

# Use uv Python by default
cat << "EOF" >> ~/.profile
export PATH=$(uv python find $python_version)../:${PATH}
EOF

source ~/.profile
