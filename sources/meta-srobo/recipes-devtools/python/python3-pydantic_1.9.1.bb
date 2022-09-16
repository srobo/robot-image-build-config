SUMMARY = "Data validation and settings management using python 3.6 type hinting"
DESCRIPTION = "Data validation and settings management using python 3.6 type hinting"
HOMEPAGE = "https://github.com/samuelcolvin/pydantic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

SRC_URI[sha256sum] = "1ed987c3ff29fff7fd8c3ea3a3ea877ad310aae2ef9889a119e22d3f2db0691a"

PYPI_PACKAGE = "pydantic"
inherit pypi setuptools3

RDEPENDS:${PN} = "python3-typing-extensions"

BBCLASSEXTEND = "native nativesdk"
