
const fs = require('fs');

const problems = JSON.parse(fs.readFileSync("./problems.json"));

const sortedKeys = Object.keys(problems).sort(function (a, b) {
    const aa = a.toLowerCase();
    const bb = b.toLowerCase();
    if (aa == bb) return 0;
    return aa > bb ? 1 : -1;
});

var content = [
    "LeetCode | LintCode | Problem Name",
    "---|---|---"
];
sortedKeys.forEach(function(key) {
    const problem = problems[key];
    const urlParts = (problem['leetcode_url'] || problem['lintcode_url']).split("/");
    const solutionLinkName = urlParts[urlParts.length - 1];
    const exists = fs.existsSync('../problems/' + solutionLinkName + ".md");
    const row = [
        'leetcode_num' in problem ? "[LeetCode " + problem['leetcode_num'] + "](" + problem['leetcode_url'] + ")" : "-",
        'lintcode_num' in problem ? "[LintCode " + problem['lintcode_num'] + "](" + problem['lintcode_url'] + ")" : "-",
        exists ? "[" + key + "](problems/" + solutionLinkName + ".md)" : key
];

    content.push(row.join("|"));
});

fs.writeFileSync("index_table.md", content.join("\n"));
