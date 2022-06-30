require recipes-kernel/linux/linux-mainline-common.inc
FILESEXTRAPATHS:prepend = "${FILE_DIRNAME}/linux-licheerv:"
SUMMARY = "Nezha dev kernel recipe"

SRCREV_meta ?= "ea948a0983d7b7820814e5bce4eda3079201bd95"
SRCREV_machine ?= "fe178cf0153d98b71cb01a46c8cc050826a17e77"
FORK ?= "smaeul"
BRANCH ?= "riscv/d1-wip"
KMETA = "kernel-meta"

# It is necessary to add to SRC_URI link to the 'yocto-kernel-cache' due to
# override of the original SRC_URI:
# "do_kernel_metadata: Check the SRC_URI for meta-data repositories or
# directories that may be missing"
SRC_URI = " \
        git://github.com/${FORK}/linux.git;name=machine;protocol=https;branch=${BRANCH} \
        git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.15;destsuffix=${KMETA} \
        file://licheerv_linux_defconfig \
    "

LINUX_VERSION ?= "5.19-rc1"
LINUX_VERSION_EXTENSION:append = "-licheerv"

KERNEL_FEATURES += "features/cgroups/cgroups.cfg"
KERNEL_FEATURES += "ktypes/standard/standard.cfg"

KCONFIG_MODE = "licheerv_linux_defconfig"

COMPATIBLE_MACHINE = "(licheerv)"
