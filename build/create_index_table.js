
const fs = require('fs');

const problems = JSON.parse(fs.readFileSync("./problems.json"));

const sortedKeys = Object.keys(problems).sort(function (a, b) {
    const aa = a.toLowerCase();
    const bb = b.toLowerCase();
    if (aa == bb) return 0;
    return aa > bb ? 1 : -1;
});

var content = [
    "LeetCode/LintCode Solutions",
    "==========================",
    "",
    "Solutions for the most common coding interview questions. Indexed by LeetCode and LintCode.",
    "",
    "Problem Name | LeetCode | LintCode",
    "---|---|---"
];
sortedKeys.forEach(function(key) {
    const problem = problems[key];
    const urlParts = (problem['leetcode_url'] || problem['lintcode_url']).split("/");
    const solutionLinkName = urlParts[urlParts.length - 1];
    const exists = fs.existsSync('../problems/' + solutionLinkName + ".md");
    const row = [
        exists ? "[" + key + "](problems/" + solutionLinkName + ".md)" : key,
        'leetcode_num' in problem ? "[LeetCode " + problem['leetcode_num'] + "](" + problem['leetcode_url'] + ")" : "-",
        'lintcode_num' in problem ? "[LintCode " + problem['lintcode_num'] + "](" + problem['lintcode_url'] + ")" : "-",

];

    content.push(row.join("|"));
});

fs.writeFileSync("../README.md", content.join("\n"));
