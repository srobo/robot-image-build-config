#!/bin/bash
if [ "$1" == "nocompress" ]; then
    SKIP_COMPRESSION="true"
else
    SKIP_COMPRESSION="false"
fi

SROBO_NAME="Student Robotics OS"
SROBO_VERSION="$(git describe --tags --always)"

rm -f *-image-*.img.xz
rm -f *-image-*.img

docker run --rm --privileged \
    -v /dev:/dev \
    -v ${PWD}:/build \
    mkaczanowski/packer-builder-arm:latest \
    build \
    -var "SROBO_NAME=${SROBO_NAME}" \
    -var "SROBO_VERSION=${SROBO_VERSION}" \
    -var "SKIP_COMPRESSION=${SKIP_COMPRESSION}" \
    pi.json
