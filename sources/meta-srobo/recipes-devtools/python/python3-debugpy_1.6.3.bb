SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://aka.ms/debugpy"
AUTHOR = "Microsoft Corporation <ptvshelp@microsoft.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file:///${WORKDIR}/LICENSE;md5=18496e0e5a38c5caaade8503120ef9ea"

SRC_URI = " \
    https://files.pythonhosted.org/packages/e4/d6/ed74635ad235293a77f65ccaa17ac3c6012839126f0512a5a53c7cbf82ff/debugpy-1.6.3-py2.py3-none-any.whl;downloadfilename=debugpy-${PV}-py3-none-any.zip;subdir=${BP};name=whl \
    file://LICENSE \
"
SRC_URI[whl.sha256sum] = "84c39940a0cac410bf6aa4db00ba174f973eef521fbe9dd058e26bcabad89c4f"

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/debugpy \
    ${libdir}/${PYTHON_DIR}/site-packages/debugpy-${PV}.dist-info \
"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/debugpy
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/debugpy-${PV}.dist-info

    # install -m 644 ${S}/debugpy/* ${D}${libdir}/${PYTHON_DIR}/site-packages/debugpy
    rm ${S}/debugpy/_vendored/pydevd/pydevd_attach_to_process/*.so
    cp -R --no-dereference --preserve=mode,links -v ${S}/debugpy/* ${D}${libdir}/${PYTHON_DIR}/site-packages/debugpy
    install -m 644 ${S}/debugpy-${PV}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/debugpy-${PV}.dist-info/
}
