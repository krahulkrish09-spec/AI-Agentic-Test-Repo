#!/usr/bin/env bash
set -euo pipefail

if [[ -z "${MAVEN_MIRROR_URL:-}" ]]; then
  cat <<'MSG'
ERROR: MAVEN_MIRROR_URL is not set.
This environment blocks direct access to Maven Central (HTTP 403 via proxy).

Fix:
  1) Export an allowed internal mirror URL
     export MAVEN_MIRROR_URL=https://<your-artifactory-or-nexus>/repository/maven-public/
  2) Re-run this script.
MSG
  exit 1
fi

echo "Using MAVEN_MIRROR_URL=${MAVEN_MIRROR_URL}"
mvn -U clean test
