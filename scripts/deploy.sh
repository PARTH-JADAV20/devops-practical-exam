#!/bin/bash
set -euo pipefail

# Usage: deploy.sh artifact.jar port
ARTIFACT="$1"
PORT="${2:-8080}"
APP_DIR="/opt/studentcrud"
LOG_FILE="/var/log/studentcrud.log"

echo "Deploying ${ARTIFACT} to ${APP_DIR} and starting on port ${PORT}"

# Create app dir if missing
sudo mkdir -p ${APP_DIR}
sudo chown $(whoami):$(whoami) ${APP_DIR}

# Stop previous instance (best-effort)
pkill -f "${ARTIFACT}" || true

# Move artifact into place
mv ~/${ARTIFACT} ${APP_DIR}/${ARTIFACT}

# Start application in background with nohup
nohup java -jar ${APP_DIR}/${ARTIFACT} --server.port=${PORT} >> ${LOG_FILE} 2>&1 &

echo "Started ${ARTIFACT} on port ${PORT}. Logs: ${LOG_FILE}"
