#!/bin/bash
set -eux -o pipefail

# Install pyenv
curl -L https://github.com/pyenv/pyenv-installer/raw/master/bin/pyenv-installer | bash

# Configure pyenv
cat << "EOF" >> ~/.profile
export PYENV_ROOT="$HOME/.pyenv"
command -v pyenv >/dev/null || export PATH="$PYENV_ROOT/bin:$PATH"
eval "$(pyenv init -)"

# Enable Python optimizations
export PYTHON_CONFIGURE_OPTS='--enable-optimizations --with-lto'
export PYTHON_CFLAGS='-march=native -mtune=native'
EOF

source ~/.profile

python_version="3.11.5"

# Install python
pyenv update
pyenv install $python_version

# Set python to default to pyenv in all shells for robot user
pyenv global $python_version
