# README

0. install packages `$ npm install cheerio`
1. manually download the index page from LeetCode/LintCode(need to scroll down to show the full list. TODO: automate it)
1. `$ node parse_index.js` => generate `problems.json`
1. `$ node create_readme.js`
1. `$ node create_summary.js`
