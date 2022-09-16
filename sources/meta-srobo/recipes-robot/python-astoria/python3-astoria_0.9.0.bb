SUMMARY = "Robot Management System for Student Robotics Kit"
DESCRIPTION = "Robot Management System for Student Robotics Kit"
HOMEPAGE = "https://github.com/srobo/astoria"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=afb9f374f84b496f0a6f7b4d8d76d533"

SRC_URI[sha256sum] = "1c48ab9938c4706c688368c0773abcb81b9b512b792c6f4ac8f7f5142ed6b4e5"

PYPI_PACKAGE = "astoria"
inherit pypi setuptools3

RDEPENDS:${PN} = "hostapd ${PYTHON_PN}-pydantic ${PYTHON_PN}-click ${PYTHON_PN}-dbus-next ${PYTHON_PN}-gmqtt ${PYTHON_PN}-tomli ${PYTHON_PN}-tomli-w udisks2"

BBCLASSEXTEND = "native nativesdk"
