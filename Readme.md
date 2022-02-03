Build configuration for yocto based robot image
===============================================

This repository contains the configuration and helper scripts for building the student robotics robot image using yocto.

Quickstart
----------

Then run the following commands to setup the build environment.

```
mkdir srobo-build
cd srobo-build
git clone <this repo url>
```

Run this script to install the required yocto dependecies and setup the submodules.
This is only valid for a system using apt.

```
source ./scripts/setup.sh
```

You can then activate the build environment in a terminal by running the following, it is best to run this in bash as some shells dont work correctly with yocto.

```
source ./setup-env.sh
```

The image can then be built by running the following command, this will take some time on the first build as it downloads and build all components of the image.

```
bitbake srobo-image-robot
```

[yocto-deps]: https://www.yoctoproject.org/docs/2.4.2/yocto-project-qs/yocto-project-qs.html#packages

