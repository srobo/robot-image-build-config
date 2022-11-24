SUMMARY = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
DESCRIPTION = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
HOMEPAGE = "https://github.com/srobo/zoloto"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bfd7580e6f0deacd183d33dd0ee386d8"

SRCREV = "a9586685b18f2f473849d9838c5578fea41ea9ab"
SRC_URI = "git://github.com/srobo/zoloto;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} = "opencv ${PYTHON_PN}-pyquaternion ${PYTHON_PN}-numpy ${PYTHON_PN}-cached-property"

BBCLASSEXTEND = "native nativesdk"

