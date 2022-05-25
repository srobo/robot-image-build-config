#!/bin/bash

set -e

if [ "$EUID" -ne 0 ]; then
    echo "Please run as root"
    exit
fi

if [ $# -ne 2 ]; then
    echo "Usage: $0 <output filename> <version string>"
    exit
fi

if [ -b "$1" ]; then
    echo "Output will be flashed to $1"
else
    echo "Output filename will be: $1.img.xz"
fi
echo "Version string will be: $2"
echo ""

if [ ! -b "$1" ]; then
    echo "Is this correct"
    select yn in "Yes" "No"; do
        case $yn in
            "Yes") break ;;
            *) exit ;;
        esac
    done
fi

echo ""

if [ ! -d outputs ]; then
    echo "Creating output file directory"
    mkdir -p outputs
fi

script_dir="$(dirname "$(readlink -f "$0")")"
image_dir="$script_dir/../build/tmp/deploy/images/raspberrypi4-64"
if [ -b "$1" ]; then
    output_path="$1"
else
    output_path="outputs/${1}.img"
fi

bmaptool copy --bmap "$image_dir/srobo-image-robot-raspberrypi4-64.wic.bmap" "$image_dir/srobo-image-robot-raspberrypi4-64.wic.bz2" "$output_path"

mount_path="$script_dir/../imagemnt"
if [ ! -d "$mount_path" ]; then
    mkdir -p "$mount_path"
fi

if [ -b "$1" ]; then
    # Mount the rootfs partition of our target block device
    mount "${1}2" "$mount_path"
    echo "Mounted rootfs"
else
    # Create loopback device and mount it

    loop_dev=$(losetup --show -P -f "outputs/${1}.img")
    mount ${loop_dev}p1 "$mount_path"
    echo "Mounted image"
fi
echo ""

# Set the astroia vesion
echo "Updating the version number in astoria.toml"
sed -i "s/%VERSIONSTRING%/$2/g" "$mount_path/etc/astoria.toml"

echo ""

# Unmount image
echo "Unmounting"
umount "$mount_path"

echo ""

if [ -b "$1" ]; then
    echo "Syncing disks"
    sync
else
    # Create output image
    echo "Compressing output image"
    xz -v "$output_path"

    echo ""
    echo "Image created at: $output_path.xz"
fi
