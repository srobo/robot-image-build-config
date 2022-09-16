SUMMARY = "Student Robotics kit network configuation"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a35952eb03763766aeed1257d0fc216"

SRC_URI = " \
    file://LICENSE \
    file://dnsmasq.conf \
    file://br0.netdev \
    file://br0.network \
    "

RDEPENDS:${PN} = "dnsmasq lighttpd"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/etc/dnsmasq.d/
    install -m 0644 ${WORKDIR}/dnsmasq.conf ${D}/etc/dnsmasq.d/srobo.conf
    install -d ${D}/etc/systemd/network
    install -m 0644 ${WORKDIR}/br0.netdev ${D}/etc/systemd/network/br0.netdev
    install -m 0644 ${WORKDIR}/br0.network ${D}/etc/systemd/network/br0.network
    install -d ${D}/etc/sysctl.d
    echo "net.ipv4.ip_forward=1" > ${D}/etc/sysctl.d/ip_forward.conf
}
