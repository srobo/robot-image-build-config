if [ ! -d build/conf ]; then
    echo "Creating build directory"
    mkdir -p build/conf
fi

for conf in odroid-u3-sonfig/*; do
    config="$(basename $conf)"
    if [ ! -e "build/conf/$config" ]; then
        echo "Creating symlink for $conf to build/conf/$config"
	ln -s "../../$conf" "build/conf/$config"
    fi
done

source sources/poky/oe-init-build-env build
