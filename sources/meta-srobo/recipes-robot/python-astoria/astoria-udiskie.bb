SUMMARY = "Astoria config to use udiskie for automounting"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

inherit systemd

DEPENDS = "polkit astoria-config"

RDEPENDS:${PN} = "astoria-config python3-astoria python3-udiskie"

SRC_URI = " \
    file://LICENSE \
    file://50-udiskie.rules \
    file://astoria-udiskie.service \
    file://astoria-udiskie.yml \
    "

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "astoria-udiskie.service"

DIRFILES = "1"

do_install () {
    install -d ${D}/etc/polkit-1/rules.d/
    install -m 0600 -o polkitd -g polkitd ${WORKDIR}/50-udiskie.rules ${D}/etc/polkit-1/rules.d/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astoria-udiskie.service ${D}${systemd_system_unitdir}
    install -d ${D}/etc/
    install -m 0644 ${WORKDIR}/astoria-udiskie.yml ${D}/etc/
}
