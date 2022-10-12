SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRC_URI[sha256sum] = "5e7384ab3fabbba7193376d5add5c0ec6abe2b04f5cf20189a8f145026247c71"

PYPI_PACKAGE = "sr.robot3"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-j5 ${PYTHON_PN}-j5-zoloto ${PYTHON_PN}-astoria"

BBCLASSEXTEND = "native nativesdk"
