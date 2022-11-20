
SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://aka.ms/debugpy"
AUTHOR = "Microsoft Corporation <ptvshelp@microsoft.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"

SRC_URI = "https://files.pythonhosted.org/packages/8f/23/8dd369ef3a92bf5fdb4bf0cb84b721efbec43ae81b4f3694f6214b20d6d6/debugpy-1.6.3.zip"
SRC_URI[sha256sum] = "e8922090514a890eec99cfb991bab872dd2e353ebb793164d5f01c362b9a40bf"

S = "${WORKDIR}/debugpy-${PV}"

inherit setuptools3
