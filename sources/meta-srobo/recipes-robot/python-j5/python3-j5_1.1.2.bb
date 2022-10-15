SUMMARY = "j5 Robotics Framework"
DESCRIPTION = "j5 Robotics Framework"
HOMEPAGE = "http://github.com/j5api/j5"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=25c025cfa0f36e678918b6a1ae4d5985"

SRC_URI[sha256sum] = "1e7c74ce97a976f7489464daefa59e8791679c88223f7b1e7c351155763dc0bc"

PYPI_PACKAGE = "j5"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-pyusb ${PYTHON_PN}-cached-property ${PYTHON_PN}-typing-extensions ${PYTHON_PN}-pyquaternion"

BBCLASSEXTEND = "native nativesdk"
