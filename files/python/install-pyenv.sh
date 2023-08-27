#!/bin/bash
# set -eux -o pipefail

# Install pyenv
curl https://pyenv.run | bash

# Configure pyenv
cat << "EOF" >> ~/.profile
export PYENV_ROOT="$HOME/.pyenv"
command -v pyenv >/dev/null || export PATH="$PYENV_ROOT/bin:$PATH"
eval "$(pyenv init -)"
EOF

source ~/.profile

# Install python 3.11.5
pyenv update
pyenv install 3.11.5
