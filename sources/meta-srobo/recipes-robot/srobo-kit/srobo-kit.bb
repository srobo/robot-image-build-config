SUMMARY = "Package set to define a SR Kit"

inherit useradd
USERADD_PACKAGES = "srobo-kit"
# password: robot
USERADD_PARAM:${PN} = "--create-home -r -s /bin/bash -G video,dialout -p '\$6\$W19UqGeau5E2UOf1\$GxE7Tg0wUe02Phl2H9yDj.6bdGtS.x3OVjUvsy2WoBJ8mRSKRlSs46l6.77FEvAa8fWYoXzok5vrVNZjXX81g0' robot"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

SRC_URI = " \
    file://LICENSE \
    file://10-srobo.rules \
    file://astoria.toml \
    file://mount_options.conf \
    "

DEPENDS = "astoria-config"

RDEPENDS:${PN} = " \
    astoria-udiskie \
    python3-kchd \
    python3-sr-robot3 \
    servohack \
    kit-ui \
    python3-rtui \
    "

S = "${WORKDIR}"

do_install () {
    install -d ${D}/usr/lib/udev/rules.d/
    install -d ${D}/etc/
    install -d ${D}/var/srobo/cache/
    chown -R robot:robot ${D}/var/srobo/cache/
    install -m 0644 ${WORKDIR}/10-srobo.rules ${D}/usr/lib/udev/rules.d/
    install -m 0644 ${WORKDIR}/astoria.toml ${D}/etc/
    install -d ${D}/etc/udisks2/
    install -m 0644 ${WORKDIR}/mount_options.conf ${D}/etc/udisks2/
}
