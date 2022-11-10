SUMMARY = "Removable disk automounter for udisks"
DESCRIPTION = "Removable disk automounter for udisks"
HOMEPAGE = "https://github.com/coldfix/udiskie"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=f7d6dd19680ac1c4995e76442b897458"

SRC_URI[sha256sum] = "1f87ab59cb112915be044fc2ae0b0000a48189af54353793b896ec6c289a0f7c"

PYPI_PACKAGE = "udiskie"
inherit pypi setuptools3

DEPENDS += "gettext-native"
RDEPENDS:${PN} += "python3-setuptools python3-pygobject python3-pyyaml python3-docopt udisks2"

BBCLASSEXTEND = "native nativesdk"

do_install:append() {
    rm -rf ${D}/usr/share/zsh
}
