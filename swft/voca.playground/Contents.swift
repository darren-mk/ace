import UIKit

// function //
func add(x: Int, y: Int) -> Int {
    return x + y }
add(x: 2, y: 3)

// enum //
enum Fruits: CaseIterable {
    case apple, orange, mango }
let choice = Fruits.mango
func pickNum(x: Fruits) -> Int {
    let v = switch x {
                case .apple: 1
                case .orange: 2
                case .mango: 3 }
    return v }
print(pickNum(x: Fruits.orange))
// 2
for fruit in Fruits.allCases {
    print(fruit) }
// apple
// orange
// mango

// structure //
struct Person {
    var age = 0
    var name: String }
let darren = Person(age: 100, name: "Darren")
print(darren)
var kim = darren
kim.age = 50
print(darren.age)
print(kim.age)

// class
class Cruise {
    var name = ""
    var occupancy = 0 }
let anthem = Cruise()
anthem.occupancy = 2000
var liberty = anthem
liberty.occupancy = 1000
print(anthem.occupancy)
print(liberty.occupancy)
