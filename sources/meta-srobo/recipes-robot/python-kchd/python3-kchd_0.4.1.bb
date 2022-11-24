SUMMARY = "kchd"
DESCRIPTION = "KCH LED Control Daemon"
HOMEPAGE = "http://github.com/srobo/kchd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d55c4f33861e6f6551ac6a94bd74dbe"

SRC_URI[sha256sum] = "8b73264b6c8c3745d519ca709fe3538117e2170becd0b4c067bd059480e64d95"

PYPI_PACKAGE = "kchd"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-astoria rpi-gpio"

BBCLASSEXTEND = "native nativesdk"

