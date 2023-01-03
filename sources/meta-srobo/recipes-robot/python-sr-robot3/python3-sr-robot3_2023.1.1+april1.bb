SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRCREV = "8d446ef96618a294ca753910f1ba76773cde3204"
SRC_URI = "git://github.com/srobo/sr-robot3;protocol=https;branch=april_vision"

S = "${WORKDIR}/git"

inherit python_poetry_core

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-j5 ${PYTHON_PN}-april-vision ${PYTHON_PN}-astoria ${PYTHON_PN}-paho-mqtt"

BBCLASSEXTEND = "native nativesdk"

