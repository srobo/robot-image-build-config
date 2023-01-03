SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI[sha256sum] = "3e72c18e661b6cee48617aa239114813cdcc94f0d20913b656caa53e99fc357d"

PYPI_PACKAGE = "april-vision"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy opencv"

BBCLASSEXTEND = "native nativesdk"
