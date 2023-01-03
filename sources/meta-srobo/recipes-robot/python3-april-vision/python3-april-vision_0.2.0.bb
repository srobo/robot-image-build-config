SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI[sha256sum] = "cc08234bc4df0da4307966bbb9478f62e87f1d47933946258ffb21407d019881"

PYPI_PACKAGE = "april_vision"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy"

BBCLASSEXTEND = "native nativesdk"
