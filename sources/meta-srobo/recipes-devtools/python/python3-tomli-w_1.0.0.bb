SUMMARY = "A lil' TOML writer"
DESCRIPTION = "A lil' TOML writer"
HOMEPAGE = "https://github.com/hukkin/tomli-w"
LICENSE = "MIT"
LICENSE_PATH += "${WORKDIR}/tomli_w-${PV}/LICENSE"
LIC_FILES_CHKSUM = "file://${WORKDIR}/tomli_w-${PV}/LICENSE;md5=aaaaf0879d17df0110d1aa8c8c9f46f5"

SRC_URI[sha256sum] = "f463434305e0336248cac9c2dc8076b707d8a12d019dd349f5c1e382dd1ae1b9"

PYPI_PACKAGE = "tomli-w"
PYPI_ARCHIVE_NAME ?= "tomli_w-${PV}.${PYPI_PACKAGE_EXT}"
PEP517_SOURCE_PATH = "${WORKDIR}/tomli_w-${PV}"

inherit pypi python_flit_core

BBCLASSEXTEND = "native nativesdk"
