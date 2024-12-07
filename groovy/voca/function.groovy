def greet(name) {
    return "hello, $name"
}

def msg = greet "darren"
println msg
// hello, darren

def addTwoNums(int a, int b) {
    return a + b
}

def result = addTwoNums(1, 2)
println result
// 3
