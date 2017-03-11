#!/usr/bin/env bash

cd build
node create_problems.js
node create_readme.js
node create_summary.js
cd ..

git add -A
git commit -m "update"
git push origin master