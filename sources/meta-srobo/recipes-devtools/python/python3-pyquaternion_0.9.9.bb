SUMMARY = "A fully featured, pythonic library for representing and using quaternions."
HOMEPAGE = "http://kieranwynn.github.io/pyquaternion/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2e781a9e674524ac159509cb4c72cfc4"

SRC_URI = "git://github.com/KieranWynn/pyquaternion.git;protocol=https;branch=master"

# Modify these as desired
PV = "0.9.9"
SRCREV = "99025c17bab1c55265d61add13375433b35251af"

S = "${WORKDIR}/git"

inherit setuptools3

#PACKAGECONFIG ?= "dev test"
PACKAGECONFIG[dev] = ",,,python3-mkdocs"
PACKAGECONFIG[test] = ",,,python3-nose"

RDEPENDS:${PN} += "python3-numpy python3-core python3-math python3-numpy python3-unittest"
