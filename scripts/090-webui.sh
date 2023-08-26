#!/bin/bash
set -eux -o pipefail

# Install the webserver
apt-get -y update
apt-get -y install nginx

# Download latest kit-ui release
UI_URL="https://api.github.com/repos/srobo/kit-ui/releases/latest"

mkdir /tmp/webui
curl -s $UI_URL \
| sed -nr 's/"browser_download_url": "(.*\.zip)"/\1/p' \
| wget -O /tmp/webui/webui.zip -qi -

# Move website to webserver dir
unzip /tmp/webui/webui.zip -d /tmp/webui/

mkdir /usr/share/kit-ui
mv /tmp/webui/dist/* /usr/share/kit-ui/

chown -R root:www-data /usr/share/kit-ui
chmod -R 755 /usr/share/kit-ui

# Set config
rm /etc/nginx/sites-enabled/default
mv /tmp/packer/webui/kit-ui.nginx /etc/nginx/sites-enabled/
