FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://issue \
            file://motd"

do_install:append () {
    install -d ${D}/etc/
    install -m 0644 ${S}/issue ${D}/etc/issue
    sed -i 's/%VERSION%/${SROBO_VERSION}/' ${D}/etc/issue
    install -m 0644 ${S}/motd ${D}/etc/motd
}
 
