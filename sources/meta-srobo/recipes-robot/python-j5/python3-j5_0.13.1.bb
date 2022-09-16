SUMMARY = "j5 Robotics Framework"
DESCRIPTION = "j5 Robotics Framework"
HOMEPAGE = "http://github.com/j5api/j5"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRC_URI[sha256sum] = "02bd201fbd57fbe7d90c0fc6314b7280741151505aecb2a518fc73c57bef0a90"

PYPI_PACKAGE = "j5"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-pyusb ${PYTHON_PN}-cached-property ${PYTHON_PN}-typing-extensions ${PYTHON_PN}-pyquaternion"

BBCLASSEXTEND = "native nativesdk"
