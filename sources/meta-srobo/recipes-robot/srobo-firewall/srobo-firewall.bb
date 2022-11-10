SUMMARY = "Package for SR nftables configuration"
inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d8d73c88a5f93d1407ca45b7c7b2b31"

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

