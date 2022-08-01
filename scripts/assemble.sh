#!/bin/bash

set -e

if [ "$EUID" -ne 0 ]; then
    echo "Please run as root"
    exit
fi

if [ $# -ne 1 ]; then
    echo "Usage: $0 <output filename> <version string>"
    exit
fi

if [ -b "$1" ]; then
    echo "Output will be flashed to $1"
else
    echo "Output filename will be: $1.img.xz"
fi
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

bmaptool copy --nobmap "$image_dir/srobo-image-robot-raspberrypi4-64.wic.bz2" "$output_path"

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
