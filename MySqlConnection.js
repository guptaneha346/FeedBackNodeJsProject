var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "feedback"
});

con.connect(function (err) {
  if (err) throw err;
  console.log("Connected!");
});

const executeQuery = function (query) {
  console.log("Executing query: " + query);

  con.query(query, function (error) {
    if (error) throw error;
  });
};

exports.executeQuery = executeQuery;







