enum Fruits:
  case Apple, Orange, Melon
// defined class Fruits

val a = Fruits.Apple
// val a: Fruits = Apple


enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

case class Pizza (
   crustSize: CrustSize,
   crustType: CrustType,
   toppings: Set[Topping] )

val cheesePizza = Pizza (
  crustSize = CrustSize.Medium,
  crustType = CrustType.Thin,
  toppings = Set(Topping.Cheese, Topping.Onions) )

def toppingPrice(t: Topping): Double = t match
  case Topping.Cheese
       | Topping.Onions => 0.5
  case Topping.Pepperoni
       | Topping.BlackOlives
       | Topping.GreenOlives => 0.75

















