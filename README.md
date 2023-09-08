# Student Robotics OS

Student Robotics OS is a Linux distribution for use on the [Student Robotics](https://studentrobotics.org) kit.

This repository contains packer build scripts to build disk images.

## Requirements

- Docker
- This repository cloned

## Usage

Simply run the `./build-image.sh` script.
Packer will download all needed files and save the output image to `Student Robotics OS-image-<GIT-TAG/HASH>.img.xz`, ready for distribution.
Running `./build-image.sh nocompress` will skip the compression step, which greatly speeds up the build process.
