
const fs = require('fs');

const problems = JSON.parse(fs.readFileSync("./problems.json"));

const sortedKeys = Object.keys(problems).sort(function (a, b) {
    const aa = a.toLowerCase();
    const bb = b.toLowerCase();
    if (aa == bb) return 0;
    return aa > bb ? 1 : -1;
});

var content = [

];

sortedKeys.forEach(function(key) {
    const problem = problems[key];
    const urlParts = (problem['leetcode_url'] || problem['lintcode_url']).split("/");
    const name = urlParts[urlParts.length - 1];


    if (fs.existsSync("../problems/" + name + ".md")) {
        content.push("* [" + key + "](problems/" + name + ".md)");
    }
});

fs.writeFileSync("../SUMMARY.md", content.join("\n"));
