SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI[sha256sum] = "ca1af02526c516650a37a12b08dc18b476e829fe54ad8d690473b029972f1af3"

PYPI_PACKAGE = "april_vision"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy opencv"

BBCLASSEXTEND = "native nativesdk"
