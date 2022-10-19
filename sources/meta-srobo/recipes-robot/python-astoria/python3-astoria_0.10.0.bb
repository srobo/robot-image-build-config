SUMMARY = "Robot Management System for Student Robotics Kit"
DESCRIPTION = "Robot Management System for Student Robotics Kit"
HOMEPAGE = "https://github.com/srobo/astoria"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=caab9905fbe5565770c80322899abeb1"

SRC_URI[sha256sum] = "c2a63259ee8ebc33f54b341203979818df59222b010f7a0ecd3ace0f80d96dfc"

PYPI_PACKAGE = "astoria"
inherit pypi setuptools3

RDEPENDS:${PN} = "hostapd ${PYTHON_PN}-pydantic ${PYTHON_PN}-click ${PYTHON_PN}-dbus-next ${PYTHON_PN}-gmqtt ${PYTHON_PN}-tomli ${PYTHON_PN}-tomli-w udisks2"

BBCLASSEXTEND = "native nativesdk"
