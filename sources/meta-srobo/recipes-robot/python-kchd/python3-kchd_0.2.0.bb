SUMMARY = "j5 Robotics Framework"
DESCRIPTION = "j5 Robotics Framework"
HOMEPAGE = "http://github.com/srobo/kchd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d55c4f33861e6f6551ac6a94bd74dbe"

SRC_URI[sha256sum] = "8fa8b1c0cfaec9e844954ef09cb3f9a49d54713e4db36fe22f523e60025984cd"

PYPI_PACKAGE = "kchd"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-astoria rpi-gpio"

BBCLASSEXTEND = "native nativesdk"
