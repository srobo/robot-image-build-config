SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI[sha256sum] = "fc5ae968fc7267f88abef47fa3bdb6148df28c763bc407c55775d089b73365f3"

PYPI_PACKAGE = "april_vision"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy opencv"

BBCLASSEXTEND = "native nativesdk"
