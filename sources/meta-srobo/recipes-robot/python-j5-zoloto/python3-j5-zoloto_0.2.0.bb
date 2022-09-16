SUMMARY = "j5 integration for Zoloto computer vision"
DESCRIPTION = "j5 integration for Zoloto computer vision"
HOMEPAGE = "https://github.com/j5api/j5-zoloto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRC_URI[sha256sum] = "e7040a14bb5b73b5c847de66e07037505c01810640ab7e7dc6e36e7adaf5e260"

PYPI_PACKAGE = "j5_zoloto"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-zoloto"

BBCLASSEXTEND = "native nativesdk"
