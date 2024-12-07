Array(1, 2, 3, 4, 5)
  .reduce((acc, x) => acc + x * 10)
// val res0: Int = 141

def f(acc: Int, x:Int): Int =
  acc + x * 20
Array(1, 2, 3, 4, 5).reduce(f)
// val res1: Int = 281