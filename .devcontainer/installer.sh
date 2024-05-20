#!/bin/bash
# Install the Kiota CLI Tool
wget https://github.com/microsoft/kiota/releases/download/v1.14.0/linux-x64.zip
unzip linux-x64.zip
chmod +x kiota
mv kiota /usr/local/bin/kiota
rm linux-x64.zip