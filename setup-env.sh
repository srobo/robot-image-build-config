if [ ! -d build/conf ]; then
    echo "Creating build directory"
    mkdir -p build/conf
fi

for conf in odroid-u3-config/*; do
    config="$(basename $conf)"
    if [ ! -e "build/conf/$config" ]; then
        echo "Creating symlink for $conf to build/conf/$config"
	ln -s "../../$conf" "build/conf/$config"
    fi
done

if [ ! -e build/assemble.sh ]; then
    echo "Creating symlink for scripts/assemble.sh in build/assemble"
    ln -s "../scripts/assemble.sh" "build/assemble"
fi

echo "Copying Arch kernel bits into build dir"
cp -r kernel-files build/

source sources/poky/oe-init-build-env build
