SUMMARY = "Data validation and settings management using python 3.6 type hinting"
DESCRIPTION = "Data validation and settings management using python 3.6 type hinting"
HOMEPAGE = "https://github.com/samuelcolvin/pydantic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

SRC_URI[sha256sum] = "91b8e218852ef6007c2b98cd861601c6a09f1aa32bbbb74fab5b1c33d4a1e410"

PYPI_PACKAGE = "pydantic"
inherit pypi setuptools3

RDEPENDS:${PN} = "python3-typing-extensions"

BBCLASSEXTEND = "native nativesdk"
