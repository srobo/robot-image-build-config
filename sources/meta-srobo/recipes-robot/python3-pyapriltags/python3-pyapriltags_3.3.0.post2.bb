SUMMARY = "Python bindings for the Apriltags library"
DESCRIPTION = "Python bindings for the Apriltags library"
HOMEPAGE = "https://github.com/WillB97/pyapriltags"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=859bf09146db781f61937e279299e0b2"

SRC_URI[sha256sum] = "8ae61edead3f14edb5658b061a510c48986a0c86994a9859d168a8005f0d6246"

PYPI_PACKAGE = "pyapriltags"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-numpy"

BBCLASSEXTEND = "native nativesdk"
