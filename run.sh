#!/bin/bash

set -eu

if [[ $# -ne 1 ]]; then
    echo "Usage: $0 start|stop|restart" >&2
    exit 1
fi

BASE_DIR="$( pwd )"

start() {
    cd "$BASE_DIR/legacy-web/build/libs"
    chmod 755 legacy-web.jar
    ./legacy-web.jar start

    cd "$BASE_DIR/modern-web/build/libs"
    chmod 755 modern-web.jar
    ./modern-web.jar start

    echo "wait for applicatoin running..."
    sleep 15
    echo "  applicatoin running at:"
    echo "  - Legacy Web:   http://localhost:9000/"
    echo "  - Modern Web:   http://localhost:9100/"
}

stop() {
    cd "$BASE_DIR/legacy-web/build/libs"
    chmod 755 legacy-web.jar
    ./legacy-web.jar stop

    cd "$BASE_DIR/modern-web/build/libs"
    chmod 755 modern-web.jar
    ./modern-web.jar stop
}

case "$1" in
    start)   start ;;
    stop)    stop ;;
    restart) stop; start ;;
    *) echo "usage: $0 start|stop|restart" >&2
       exit 1
       ;;
esac
