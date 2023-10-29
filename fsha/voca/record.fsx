


// mutable field

type Car = 
  { maker: string
    model: string
    mutable odometer: int }

let myCar = 
  { maker = "ford"
    model = "focus"
    odometer = 12 }

myCar
(* val it: Car = { maker = "ford"
                   model = "focus"
                   odometer = 12 } *)

myCar.odometer <- 13

myCar
(* val it: Car = { maker = "ford"
                   model = "focus"
                   odometer = 13 } *)


// mutually recursive records

type Person =
  { name: string
    address: Address }
and Address = 
  { city: string 
    occupant: Person }
let rec me = 
  { name = "darren"
    address = { city = "nyc"
                occupant = me } }

// member 

type Nobility = 
  { name : string
    prefix: string }
  member this.callable() =  this.prefix + " " + this.name
let sage = 
  { name = "Sage" 
    prefix = "Mr."}
sage.callable() // "Mr. Sage"


// anonymous records 

let getStats radius =
  let d = radius * 2.0
  let a = 3.14 * (radius ** 2.0)
  let c = 2.0 * 3.14 * radius
  {| diameter = d; area = a ; circum = c |}
let stats1 = getStats 2.4
stats1.diameter // val it: float = 4.8
stats1.area // val it: float = 18.0864
stats1.circum // val it: float = 15.072
let anonymousRecord1 = 
  {| foo = "hi"
     bar = "yo" |}
let anonymousRecord2 = 
  {| anonymousRecord1 with cho = "ye" |}
type FooBar = 
  { foo : string 
    bar : string }
let regularRecord1: FooBar = 
  { foo = "hi"
    bar = "yo" }
anonymousRecord1.bar = regularRecord1.bar // true