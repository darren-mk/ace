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