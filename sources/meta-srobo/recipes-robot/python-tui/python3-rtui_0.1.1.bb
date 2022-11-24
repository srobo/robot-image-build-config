SUMMARY = "Robot Terminal User Interface"
DESCRIPTION = "Robot Terminal User Interface for Student Robotics Kit"
HOMEPAGE = "https://github.com/srobo/robot-tui"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a9ebad0e1056648b8d9a4217ca40ca29"

SRC_URI[sha256sum] = "f039168bfbecc68329d8496c106cc657daba7670155eaa10b39c4010aedd83e8"

PYPI_PACKAGE = "rtui"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-prompt-toolkit ${PYTHON_PN}-astoria"

BBCLASSEXTEND = "native nativesdk"
