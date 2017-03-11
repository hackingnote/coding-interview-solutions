
const fs = require('fs');

const fileNames = fs.readdirSync("../raw");


fileNames.map(function(filename) {
    const problemName = filename.split(".")[0];
    const content = fs.readFileSync("../raw/" + filename);
    var combined = [
        content
        ];

    if (fs.existsSync("../src/java/" + problemName)) {

        const java = fs.readFileSync("../src/java/" + problemName + "/Solution.java");

        [
            "",
            "Code(Java)",
            "----------",
            "",
            "```java",
            java,
            "```"
        ].forEach(function(line) {combined.push(line)});

        // write only if there is java solution
        fs.writeFileSync("../problems/" + filename, combined.join("\n"));
    }

    //console.log(combined);


});
