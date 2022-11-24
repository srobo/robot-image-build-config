SUMMARY = "j5 integration for Zoloto computer vision"
DESCRIPTION = "j5 integration for Zoloto computer vision"
HOMEPAGE = "https://github.com/j5api/j5-zoloto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRCREV = "1dee81326e6680503090552f7c9c47b37aaeea2d"
SRC_URI = "git://github.com/j5api/j5-zoloto;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit python_poetry_core

RDEPENDS:${PN} = "${PYTHON_PN}-zoloto"

BBCLASSEXTEND = "native nativesdk"

