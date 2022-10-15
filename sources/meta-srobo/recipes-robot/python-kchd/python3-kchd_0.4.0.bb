SUMMARY = "kchd"
DESCRIPTION = "KCH LED Control Daemon"
HOMEPAGE = "http://github.com/srobo/kchd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d55c4f33861e6f6551ac6a94bd74dbe"


SRCREV = "e28b852099d45d2a4d123577d5f344a74d72b28b"
SRC_URI = "git://github.com/srobo/kchd;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit python_poetry_core

RDEPENDS:${PN} = "${PYTHON_PN}-astoria rpi-gpio"

BBCLASSEXTEND = "native nativesdk"
