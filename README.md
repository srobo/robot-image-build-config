# Student Robotics OS

Student Robotics OS is a Linux distribution for use on the [Student Robotics](https://studentrobotics.org) kit.

This repository contains build scripts to compile disk images.

## Setup Your Build Environment

Firstly, you will need to install the dependencies for Yocto.

On Ubuntu or Debian, you can install with the following command:

```shell
sudo apt install gawk wget git-core diffstat unzip texinfo \
     build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
     xz-utils lz4 debianutils iputils-ping libsdl1.2-dev xterm zstd bmap-tools
```

If you are using a x86-based computer, you will also need to install a cross-compiler:

```shell
sudo apt install gcc-multilib
```

On openSUSE, you can install with the following command:
```shell
sudo zypper install -y python gcc gcc-c++ git chrpath make wget python-xml \
     diffstat makeinfo python-curses patch socat lz4 rpcgen zstd
```

Once your have installed the system dependencies, you will need to setup the repository:

```shell
git clone git@github.com:srobo/robot-image.git --recursive
cd robot-image
```

Next, you will need to activate the Yocto build environment. This works best if you are using `bash` as your shell.

```shell
source ./setup-env.sh
```

The `bitbake` utility can then be used to build the operating system.

## Building an Image

A complete disk image with dual partitions can be generated using the following command:

```bash
bitbake srobo-image-robot
```

The built image will be saved in `build/tmp/deploy/images/raspberrypi4-64/` with a file name like `srobo-image-robot-raspberrypi4-64-20220916204611.rootfs.wic.bz2`

You can convert it to a `img.xz` file using the `assemble` script:

```bash
sudo ./assemble srobo-image-latest
```

The `assemble` script also supports writing directly to an SD card, although caution should be taken when doing this.

```bash
sudo ./assemble /dev/sdd
```
