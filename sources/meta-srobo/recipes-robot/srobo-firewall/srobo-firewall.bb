SUMMARY = "Package for SR nftables configuration"
inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "nftables.service"

SRC_URI = " \
    file://LICENSE \
    file://nftables.conf \
    file://nftables.service \
    "

FILES:${PN} += "/lib/systemd/system"

RDEPENDS:${PN} = "nftables"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/etc/
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/nftables.service ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/nftables.conf ${D}/etc/nftables.conf
}

