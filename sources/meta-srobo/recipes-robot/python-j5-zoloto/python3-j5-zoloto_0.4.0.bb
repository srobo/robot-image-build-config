SUMMARY = "j5 integration for Zoloto computer vision"
DESCRIPTION = "j5 integration for Zoloto computer vision"
HOMEPAGE = "https://github.com/j5api/j5-zoloto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRC_URI[sha256sum] = "57aacbd7b05d6b121cc52eea21f689ef24b47fa3366699dc77be545504e386bf"

PYPI_PACKAGE = "j5_zoloto"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-zoloto"

BBCLASSEXTEND = "native nativesdk"
