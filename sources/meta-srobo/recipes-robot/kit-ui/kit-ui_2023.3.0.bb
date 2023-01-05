SUMMARY = "Browser-based interface for robots"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a35952eb03763766aeed1257d0fc216"

SRC_URI = " \
        https://github.com/srobo/kit-ui/releases/download/${PV}/kit-ui-${PV}.zip \
        file://LICENSE \
        file://lighttpd.conf \
        "

SRC_URI[sha256sum] = "05f1dbf7233b7629802fc213046a0df0276abd4fa82ce462d0a48f6a1c697cb8"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/share/kit-ui ${D}${sysconfdir}/lighttpd.d
    install -m 0644 ${WORKDIR}/lighttpd.conf ${D}${sysconfdir}/lighttpd.d/kit-ui.conf
    install -m 0644 ${WORKDIR}/dist/* ${D}/usr/share/kit-ui/
}
