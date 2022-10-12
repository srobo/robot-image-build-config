SUMMARY = "j5 Robotics Framework"
DESCRIPTION = "j5 Robotics Framework"
HOMEPAGE = "http://github.com/j5api/j5"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=25c025cfa0f36e678918b6a1ae4d5985"

SRC_URI[sha256sum] = "6b1b667a39093ccb2fae400d12580305f392d31351aae1c4692467bb9171cc5b"

PYPI_PACKAGE = "j5"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-pyusb ${PYTHON_PN}-cached-property ${PYTHON_PN}-typing-extensions ${PYTHON_PN}-pyquaternion"

BBCLASSEXTEND = "native nativesdk"
