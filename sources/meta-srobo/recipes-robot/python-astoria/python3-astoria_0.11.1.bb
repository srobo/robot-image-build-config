SUMMARY = "Robot Management System for Student Robotics Kit"
DESCRIPTION = "Robot Management System for Student Robotics Kit"
HOMEPAGE = "https://github.com/srobo/astoria"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=caab9905fbe5565770c80322899abeb1"

SRC_URI[sha256sum] = "0e9e02e6f10b1d1e14f21498190c7c797138fe8a593da40f63e5254e8e0c7de4"

PYPI_PACKAGE = "astoria"
inherit pypi setuptools3

RDEPENDS:${PN} = "hostapd ${PYTHON_PN}-pydantic ${PYTHON_PN}-click ${PYTHON_PN}-dbus-next ${PYTHON_PN}-gmqtt ${PYTHON_PN}-tomli ${PYTHON_PN}-tomli-w udisks2"

BBCLASSEXTEND = "native nativesdk"
