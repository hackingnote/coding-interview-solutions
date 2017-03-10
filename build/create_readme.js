
const fs = require('fs');

const problems = JSON.parse(fs.readFileSync("./problems.json"));

const sortedKeys = Object.keys(problems).sort(function (a, b) {
    const aa = a.toLowerCase();
    const bb = b.toLowerCase();
    if (aa == bb) return 0;
    return aa > bb ? 1 : -1;
});

var cntLeetCodeTotal = 0;
var cntLeetCodeSolved = 0;
var cntLintCodeTotal = 0;
var cntLintCodeSolved = 0;

var content = [
    "LeetCode/LintCode Solutions",
    "==========================",
    "",
    "- LeetCode: {{leetCodeSolved}} Solved / {{leetCodeTotal}} Total",
    "- LintCode: {{lintCodeSolved}} Solved / {{lintCodeTotal}} Total",
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
    var row = [];
    var leetCode = false;
    var lintCode = false;
    if (exists) {
        row.push("[" + key + "](problems/" + solutionLinkName + ".md)");
    }   else {
        row.push(key);
    }

    if('leetcode_num' in problem) {
        leetCode = true;
        cntLeetCodeTotal++;
        row.push("[LeetCode " + problem['leetcode_num'] + "](" + problem['leetcode_url'] + ")");
    } else {
        row.push("-");
    }

    if('lintcode_num' in problem) {
        lintCode = true;
        cntLintCodeTotal++;
        row.push("[LintCode " + problem['lintcode_num'] + "](" + problem['lintcode_url'] + ")");
    } else {
        row.push("-");
    }

    if (row[0][0] == '[') {
        if (leetCode) cntLeetCodeSolved++;
        if (lintCode) cntLintCodeSolved++;
    }

    content.push(row.join("|"));
});

console.log(cntLeetCodeTotal);
console.log(cntLeetCodeSolved);
console.log(cntLintCodeTotal);
console.log(cntLintCodeSolved);

const text = content.join("\n")
    .replace("{{leetCodeSolved}}", cntLeetCodeSolved)
    .replace("{{leetCodeTotal}}", cntLeetCodeTotal)
    .replace("{{lintCodeSolved}}", cntLintCodeSolved)
    .replace("{{lintCodeTotal}}", cntLintCodeTotal)

fs.writeFileSync("../README.md", text);
