var express = require('express');
var bodyParser = require('body-parser');
var sqlQuery = require('./MySqlConnection');
const Joi = require('joi');
const expressJoi = require('express-joi-validator');
var app = express();
const PORT = 8087;

const schema = {

    id: Joi.number().required()

}




app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.static('../library'));
app.set('view engine');

app.get('/', function (req, res) {
    res.sendFile('FeedBackPage.html', { root: __dirname })
});

app.post('/submit', function (req, res) {
    var sql = "insert into feedbacktable values(null,'" + req.body.subject + "','"
        + req.body.creater + "','" + req.body.traineename + "','" + req.body.empcode +
        "','" + req.body.rating1 + "','" + req.body.rating2 + "','" + req.body.rating3 +
        "','" + req.body.rating4 + "','" + req.body.rating5 + "','" + req.body.suggestion1 +
        "','" + req.body.suggestion2 + "','" + req.body.suggestion3 + "')";

    sqlQuery.executeQuery(sql);
    res.sendFile('success.html', { root: __dirname });
    console.log("feedbacksubmitted");
});


app.get('/url/:id', function (req, res) {
    var sql = "SELECT * FROM recipients WHERE id='" + req.params.id + "'";

    sqlQuery.executeQuery(sql);
    console.log("feeback form open");
    res.sendFile('FeedBackPage.html', { root: __dirname })
});

app.get('/response', function (req, res) {
    var sql = "SELECT * FROM feedbacktable ";

    sqlQuery.executeQueryWithCallback(sql, function (results) {
        res.writeHeader(200, { "Content-Type": "text/html" });
        res.write("<table border='1'><tr><th>Trainee Name</th><th> Employee Code</th><th>The state objective of the training were met</th></tr>");
        for (var index = 0; index < results.length; index++) {
            res.write("<tr>");
            res.write("<td>" + results[index].traineename + "</td>");
            res.write("<td>" + results[index].empcode + "</td>");
            res.write("<td>" + results[index].rating1 + "</td>");
            res.write("</tr>");
        }
        res.write("</table>");
        res.end();
    });
});

app.get('/api/:id', (req, res) => {
    console.log(req.params.id);

});

app.listen(8087, function () {
    console.log("Start app...")
});