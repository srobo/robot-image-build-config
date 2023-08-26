#!/bin/bash
set -eux -o pipefail

apt-get -y clean

rm -rf $HOME/.cache /tmp/* /var/lib/apt/lists/* /var/tmp/* /var/log/*
