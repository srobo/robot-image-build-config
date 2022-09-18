SUMMARY = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
DESCRIPTION = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
HOMEPAGE = "https://github.com/RealOrangeOne/zoloto"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bfd7580e6f0deacd183d33dd0ee386d8"

SRC_URI[sha256sum] = "885678a60cad8e8ed57d857a9c219b36f13f0e351124dcc6db3485050cc6f16f"

PYPI_PACKAGE = "zoloto"
inherit pypi setuptools3

RDEPENDS:${PN} = "opencv python3-pyquaternion python3-numpy python3-cached-property"

BBCLASSEXTEND = "native nativesdk"
