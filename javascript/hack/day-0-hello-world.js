// https://www.hackerrank.com/challenges/js10-hello-world/problem

'use strict';

function greeting(parameterVariable) {
    console.log('Hello, World!');
    console.log(parameterVariable);
}

function main() {
    const parameterVariable = readLine();
    greeting(parameterVariable);
}

getUser(1, function(err, user) {
  if (err) return console.log('error 1');
  else getProfile(user.email, function(err, profile) {
    if (err) return console.log('error 2');
    else console.log(profile.avatar);
  });  
});

getUser(1)
  .then(function(user) {return getProfile(user.email);})
  .then(function(profile) {return console.log(profile.avatar);})
  .catch(function(err) { console.error(err);});


getUser(1, function(err, user) {
  if (err) return console.error(err);
  getOrders(user.id, function(err, orders) {
    if (err) return console.error(err);
    getItem(orders[0].itemId, function(err, item) {
      if (err) return console.error(err);
      console.log(user.name, item.name);
    });
  });
});

try {
  let user = await getUser(1);
  let orders = await getOrders(userId);
  let item = await getItem(orders[0].itemId);
  console.log(user.name, item.name);
} catch (err) {
  console.error(err);
}

async function getOrderDetail() {
  var [user, orders] = Promise.all([getUser(1), getOrders(1)]);
  var item = await getItem(orders[0].itemId);
  console.log(user.name, item.name);
}
