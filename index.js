var express = require('express');
var bodyParser = require('body-parser');
var sqlQuery = require('./MySqlConnection');
var app = express();
const PORT = 8085;


app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.static('../library'));
app.set('view engine');

app.get('/', function (req, res) {
    res.sendFile('FeedBackPage.html', { root: __dirname })
})

app.post('/submit', function (req, res) {
    var sql = "insert into feedbacktable values('1','" + req.body.subject + "','"
        + req.body.creater + "','" + req.body.traineename + "','" + req.body.empcode +
        "','" + req.body.rating1 + "','" + req.body.rating2 + "','" + req.body.rating3 +
        "','" + req.body.rating4 + "','" + req.body.rating5 + "','" + req.body.suggestion + "')";

    sqlQuery.executeQuery(sql);
    res.sendFile('success.html', { root: __dirname });
    console.log("feedbacksubmitted");
})

app.listen(8085, function () {
    console.log("Start app...")
});