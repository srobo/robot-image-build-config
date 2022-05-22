#!/bin/bash

# Setup process
# copy kernel-files to build dir
# symlink bake script to build dir

set -e

if [ "$EUID" -ne 0 ]; then
    echo "Please run as root"
    exit
fi

if [ $# -ne 2 ]; then
    echo "Usage: $0 <output filename> <version string>"
    exit
fi

echo "Output filename will be: $1.img.xz"
echo "Version string will be: $2"
echo ""

echo "Is this correct"
select yn in "Yes" "No"; do
    case $yn in
        "Yes") break ;;
        *) exit ;;
    esac
done

echo ""

if [ ! -d outputs ]; then
    echo "Creating output file directory"
    mkdir -p outputs
fi

bmaptool copy --bmap srobo-image-debug-raspberrypi4-64.wic.bmap srobo-image-debug-raspberrypi4-64.wic.bz2 "outputs/${1}.img"

# Create loopback device and mount it
if [ ! -d imagemnt ]; then
    mkdir -p imagemnt
fi

loop_dev=$(losetup --show -P -f "outputs/${1}.img")
mount ${loop_dev}p1 imagemnt/
echo "Mounted image"
echo ""

# Set the astroia vesion
echo "Updating the version number in astoria.toml"
sed -i "s/%VERSIONSTRING%/$2/g" imagemnt/etc/astoria.toml

echo ""

# Unmount image
echo "Unmounting"
umount imagemnt

echo ""

# Create output image
echo "Compressing output image"
xz -v "outputs/${1}.img"

echo ""
echo "Image created at: outputs/${1}.img.xz"
