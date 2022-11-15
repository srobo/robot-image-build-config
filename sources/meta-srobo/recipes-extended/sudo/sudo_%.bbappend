do_install:append () {
    echo "robot ALL=(ALL) ALL" >> ${D}${sysconfdir}/sudoers
}
