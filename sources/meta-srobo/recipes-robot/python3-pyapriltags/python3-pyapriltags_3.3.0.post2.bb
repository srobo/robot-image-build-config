SUMMARY = "Python bindings for the Apriltags library"
DESCRIPTION = "Python bindings for the Apriltags library"
HOMEPAGE = "https://github.com/WillB97/pyapriltags"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file:///${S}/pyapriltags-${PV}.dist-info/LICENSE.md;md5=859bf09146db781f61937e279299e0b2"

BBCLASSEXTEND = "native nativesdk"

SRC_URI = " \
    https://files.pythonhosted.org/packages/ee/2b/9386f775396c370f7881ba2c91769d845160e66f5a1720170b39da546227/pyapriltags-3.3.0.post2-py3-none-manylinux2014_aarch64.whl;downloadfilename=pyapriltags-${PV}-py3-none-manylinux2014_aarch64.zip;subdir=${BP} \
"
SRC_URI[sha256sum] = "8ae61edead3f14edb5658b061a510c48986a0c86994a9859d168a8005f0d6246"

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"
RDEPENDS:${PN} = "${PYTHON_PN}-numpy"

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/pyapriltags \
    ${libdir}/${PYTHON_DIR}/site-packages/pyapriltags-${PV}.dist-info \
"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/pyapriltags
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/pyapriltags-${PV}.dist-info

    cp -R --no-dereference --preserve=mode,links -v ${S}/pyapriltags/* ${D}${libdir}/${PYTHON_DIR}/site-packages/pyapriltags
    install -m 644 ${S}/pyapriltags-${PV}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/pyapriltags-${PV}.dist-info/
}
