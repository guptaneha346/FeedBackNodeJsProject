var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "feedback"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  var sql = "INSERT INTO example (id,name,email) VALUES (1, 'neha','neha@gmail.com')";

  con.query(sql, function (err, result) {
    if (err) throw err;
    console.log("1 record inserted");
  });
});





