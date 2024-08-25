#!/bin/bash
set -eux -o pipefail

python_version="3.11.5"

# Install uv
curl -LsSf https://astral.sh/uv/install.sh | sh

# Source environment for access to uv
source $HOME/.cargo/env

# Install Python
uv python install $python_version

# Use uv Python by default
cat << "EOF" >> ~/.profile
# Since there's only 1 version installed through uv,
# there's no need to specify a version
export PATH=$(dirname $(uv python find)):${PATH}
EOF

source ~/.profile

# Allow package install in uv's Python
find $(uv python dir) -name "EXTERNALLY-MANAGED" -delete
