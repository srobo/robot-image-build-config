SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI[sha256sum] = "916e977c16e99666f4c65158b557d24e18b2af09c2fdb75850fa546498cfb0cb"

PYPI_PACKAGE = "april_vision"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy opencv"

BBCLASSEXTEND = "native nativesdk"
