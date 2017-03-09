const cheerio = require('cheerio');
const fs = require('fs');

var problems = {};
parseLintCode();
parseLeetCode();

console.log("Total Unique Problems: " + Object.keys(problems).length);
fs.writeFileSync("./problems.json", JSON.stringify(problems, null, "  "));

function parseLeetCode() {
    const html = fs.readFileSync("./LeetCode.html");
    $ = cheerio.load(html);
    var cnt = 0;
    $('table tbody tr').each(function() {
        const tds = $(this).find('td');
        const name = $(tds[2]).text().trim();
        if (name == "") return;
        if (!(name in problems)) {
            problems[name] = {};
        }
        problems[name]['leetcode_num'] = parseInt($(tds[1]).text());
        problems[name]['leetcode_url'] = $(tds[2]).find('a').attr('href');
        cnt++;
    });
    console.log("LeetCode Problems: " + cnt);
}

function parseLintCode() {
    const html = fs.readFileSync('./LintCode.html');
    $ = cheerio.load(html);
    var cnt = 0;
    $('#problem_list_pagination a').each(function() {
        const raw = $(this).find('.title').text().trim();
        const parts = raw.split(".");
        const name = parts[1].trim().replace("\b", "");
        if (name == "") return;
        if (!(name in problems)) {
            problems[name] = {};
        }
        console.log(parseInt(parts[0]));
        problems[name]['lintcode_num'] = parseInt(parts[0]);
        problems[name]['lintcode_url'] = $(this).attr('href');
        cnt++;
    });

    console.log("LintCode Problems: " + cnt);
    return problems;
}

