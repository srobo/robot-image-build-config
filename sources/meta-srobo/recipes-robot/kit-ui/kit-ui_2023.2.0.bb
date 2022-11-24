SUMMARY = "Browser-based interface for robots"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a35952eb03763766aeed1257d0fc216"

SRC_URI = " \
        https://github.com/srobo/kit-ui/releases/download/${PV}/kit-ui-${PV}.zip \
        file://LICENSE \
        file://lighttpd.conf \
        "

SRC_URI[sha256sum] = "f3adc0841e93b3d93a6b61c5406510300e615e6f9c7aed676b87ea1d10c4e137"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/share/kit-ui ${D}${sysconfdir}/lighttpd.d
    install -m 0644 ${WORKDIR}/lighttpd.conf ${D}${sysconfdir}/lighttpd.d/kit-ui.conf
    install -m 0644 ${WORKDIR}/dist/* ${D}/usr/share/kit-ui/
}
