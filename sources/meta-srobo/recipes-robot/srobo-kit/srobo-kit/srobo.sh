# Add sbin to the path for non-root users so that root-only commands like shutdown/ip can be used through sudo
PATH=$PATH:/usr/local/sbin:/usr/sbin:/sbin

# Stop OpenCV using gstreamer in all sessions
export OPENCV_VIDEOIO_PRIORITY_GSTREAMER=0
