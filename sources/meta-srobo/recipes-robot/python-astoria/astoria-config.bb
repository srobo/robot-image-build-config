SUMMARY = "Astoria config files"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

inherit systemd

RDEPENDS:${PN} = "python3-astoria python3-udiskie mosquitto mosquitto-clients"

SRC_URI = " \
    file://LICENSE \
    file://astdiskd.service \
    file://astmetad.service \
    file://astprocd.service \
    file://astwifid.service \
    file://boot_40.service \
    file://kchd.service \
    "

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = " \
    astdiskd.service \
    astmetad.service \
    astprocd.service \
    astwifid.service \
    boot_40.service \
    kchd.service \
    "

DIRFILES = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astdiskd.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astmetad.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astprocd.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astwifid.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/boot_40.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/kchd.service ${D}${systemd_system_unitdir}
}
