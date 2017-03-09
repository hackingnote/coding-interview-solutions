const fs = require("fs");

fs.readdirSync("../problems").forEach(function(filename) {
    const content = fs.readFileSync("../problems/" + filename);
    const problemName = filename.split(".")[0];
    fs.mkdirSync("../src/java/" + problemName);
    fs.writeFileSync("../src/java/" + problemName + "/Solution.java", content);
});