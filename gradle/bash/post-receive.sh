#!/usr/bin/env bash
rm -rf /root/craig/project
git clone -b master /root/craig/git /root/craig/project
bash -x /root/craig/project/gradle/bash/deploy.sh