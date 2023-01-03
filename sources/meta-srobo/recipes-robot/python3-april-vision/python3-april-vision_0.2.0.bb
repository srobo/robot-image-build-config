SUMMARY = "An AprilTag marker detection library"
DESCRIPTION = "An AprilTag marker detection library"
HOMEPAGE = "https://github.com/WillB97/april_vision"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file:///${S}/april_vision-${PV}.dist-info/LICENSE;md5=166254bc339a21e92d852d180a9063cc"

SRC_URI = " \
    https://files.pythonhosted.org/packages/9f/f3/a620c73f6542fca09472e3e2ba8f9e6d39420b5bd1ef5180f46da6af2cdc/april_vision-0.2.0-py3-none-any.whl;downloadfilename=april_vision-${PV}-py3-none-any.zip;subdir=${BP} \
"
SRC_URI[sha256sum] = "cc08234bc4df0da4307966bbb9478f62e87f1d47933946258ffb21407d019881"

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"
RDEPENDS:${PN} = "${PYTHON_PN}-pyapriltags ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy"

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/april_vision \
    ${libdir}/${PYTHON_DIR}/site-packages/april_vision-${PV}.dist-info \
"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/april_vision
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/april_vision-${PV}.dist-info

    cp -R --no-dereference --preserve=mode,links -v ${S}/april_vision/* ${D}${libdir}/${PYTHON_DIR}/site-packages/april_vision
    install -m 644 ${S}/april_vision-${PV}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/april_vision-${PV}.dist-info/
}
