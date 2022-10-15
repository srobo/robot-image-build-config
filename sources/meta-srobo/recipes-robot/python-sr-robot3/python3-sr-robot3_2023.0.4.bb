SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRC_URI[sha256sum] = "0dc6c703e9ff15782d5b7f895ab06835a8ca4ba2edee52384c92b542577ecaf0"

PYPI_PACKAGE = "sr.robot3"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-j5 ${PYTHON_PN}-j5-zoloto ${PYTHON_PN}-astoria"

BBCLASSEXTEND = "native nativesdk"
