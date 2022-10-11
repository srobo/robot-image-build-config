SUMMARY = "Browser-based interface for robots"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a35952eb03763766aeed1257d0fc216"

SRC_URI = " \
        https://github.com/srobo/kit-ui/releases/download/2023.0.0/kit-ui.zip \
        file://LICENSE \
        file://lighttpd.conf \
        "

SRC_URI[sha256sum] = "a9145f25204a4e65c4132668fdcdd402e49283e814360280ffeaac996f92688d"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/share/kit-ui ${D}${sysconfdir}/lighttpd.d
    install -m 0644 ${WORKDIR}/lighttpd.conf ${D}${sysconfdir}/lighttpd.d/kit-ui.conf
    install -m 0644 ${WORKDIR}/dist/* ${D}/usr/share/kit-ui/
}
