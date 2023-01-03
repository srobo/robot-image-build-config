SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRCREV = "a13c51d9664f3a1941e7f46c6889e95a25598f65"
SRC_URI = "git://github.com/srobo/sr-robot3;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit python_poetry_core

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-j5 ${PYTHON_PN}-april-vision ${PYTHON_PN}-astoria ${PYTHON_PN}-paho-mqtt"

BBCLASSEXTEND = "native nativesdk"

