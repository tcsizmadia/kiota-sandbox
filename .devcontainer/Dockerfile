FROM --platform=linux/amd64 mcr.microsoft.com/devcontainers/java:17

WORKDIR /workspace

RUN wget https://github.com/microsoft/kiota/releases/download/v1.14.0/linux-x64.zip \
    && unzip linux-x64.zip \
    && chmod +x kiota \
    && mv kiota /usr/local/bin/kiota \
    && rm linux-x64.zip

RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    rm -rf /var/lib/apt/lists/*