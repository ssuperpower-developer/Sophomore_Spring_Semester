"use strict";

function sample1(...items) { console.log(items); }

function HI {}

sample1([ 1, 2, 3 ]);
sample1(1, 2, 3);
sample1(1, 2);

function sample2(a, b, ...c) { console.log(a, b, c); }

sample2(1, 2, 3);
sample2(1, 2, 3, 4, 5, 6);

// CallBack Funtion
/* 가장 기본적으로 함수를 매개변수로 전달하는 기능을
동작하는 것이 가장 기본적이다. */
function callThreeTimes(callback) {
  for (let i = 0; i < 3; ++i) {
    callback(i);
  }
}

function print(i) { console.log(`${i}번째 함수 호출`); }

callThreeTimes(print);

const numbers1 = [ 273, 52, 103, 32, 57 ];

numbers1.forEach(function(
    value, index, array) { console.log(`${index}번째 요소 : ${value}`); });

/* 이렇게 함수를 함수의 매개변수로 전달하는 것
numbers.function (
  function(value, index, array) {
    console.log(`${index}번째 요소 : ${value}`);
  }
)
*/

let numbers = [ 273, 52, 103, 32, 57 ];

numbers = numbers.map(function(value, index, array) { return value * value; });

numbers.forEach(console.log);

// Arrow Function
// 콜백함수를 쉽게 사용할 때, function 키워드 대신 화살표를 사용하여 함수를
// 만드는 과정을 말한다.
numbers1.forEach(
    (value, index) => { console.log(`${index}번째 요소 : ${value}`); });

// This Example is for the difference between Declare & Anonymous
// Declare Function
let add;
add = function(a, b) { return a + b; };

console.log(add(1, 3));

// Anonymous Function
let minus;
minus = (a, b) => { return a - b; };

console.log(minus(5, 3));
