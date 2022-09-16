inherit bundle

RAUC_BUNDLE_COMPATIBLE ?= "SRRaspberryPi4"

RAUC_BUNDLE_SLOTS ?= "rootfs"

RAUC_BUNDLE_FORMAT ?= "verity"

RAUC_SLOT_rootfs ?= "srobo-image-robot"

RAUC_KEY_FILE = "${THISDIR}/files/srobo.key.pem"
RAUC_CERT_FILE = "${THISDIR}/files/srobo.cert.pem"
