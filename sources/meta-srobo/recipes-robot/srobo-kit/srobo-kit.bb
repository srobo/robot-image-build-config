SUMMARY = "Package set to define a SR Kit"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

SRC_URI = " \
    file://LICENSE \
    file://10-srobo.rules \
    file://astoria.toml \
    file://exynos-blacklist.conf \
    file://mount_options.conf \
    "

DEPENDS = "astoria-config"

RDEPENDS:${PN} = "astoria-udiskie python3-sr-robot3 servohack"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/usr/lib/udev/rules.d/
    install -d ${D}/etc/
    install -d ${D}/var/srobo/cache/
    chown -R astoria:astoria ${D}/var/srobo/cache/
    install -m 0644 ${WORKDIR}/10-srobo.rules ${D}/usr/lib/udev/rules.d/
    install -m 0644 ${WORKDIR}/astoria.toml ${D}/etc/
    install -d ${D}/etc/modprobe.d/
    install -m 0644 ${WORKDIR}/exynos-blacklist.conf ${D}/etc/modprobe.d/
    install -d ${D}/etc/udisks2/
    install -m 0644 ${WORKDIR}/mount_options.conf ${D}/etc/udisks2/
}
