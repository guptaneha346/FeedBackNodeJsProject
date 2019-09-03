const faker = require('faker');
var sqlQuery = require('./MySqlConnection');
let uuid = faker.random.uuid();
console.log(uuid);