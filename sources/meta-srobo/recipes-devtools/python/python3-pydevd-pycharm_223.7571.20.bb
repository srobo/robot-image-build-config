SUMMARY = "PyCharm Debugger (used in PyCharm and PyDev)"
HOMEPAGE = "https://github.com/JetBrains/intellij-community"
AUTHOR = "JetBrains, Fabio Zadrozny and others <>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=30b3836521b3d65bef598bbc358a3afa"

SRC_URI[sha256sum] = "664c7de24b5012bfc57917b05c33e3d036df5d05b176973e41ffd7a4711c05bf"

PYPI_PACKAGE = "pydevd-pycharm"

S = "${WORKDIR}/pydevd-pycharm-223.7571.20"
inherit pypi setuptools3
