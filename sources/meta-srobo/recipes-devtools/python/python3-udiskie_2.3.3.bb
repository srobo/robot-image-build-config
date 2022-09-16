SUMMARY = "Removable disk automounter for udisks"
DESCRIPTION = "Removable disk automounter for udisks"
HOMEPAGE = "https://github.com/coldfix/udiskie"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d43588ca14c7c9eccfcdfd6da5af5351"

SRC_URI[sha256sum] = "20ff228ed1aaf61509a0101bf1ddcb99c585ee2048be2d0714a3cec2746d4f69"

PYPI_PACKAGE = "udiskie"
inherit pypi setuptools3

DEPENDS += "gettext-native"
RDEPENDS:${PN} += "python3-setuptools python3-pygobject python3-pyyaml python3-docopt udisks2"

BBCLASSEXTEND = "native nativesdk"

do_install:append() {
    rm -rf ${D}/usr/share/zsh
}
