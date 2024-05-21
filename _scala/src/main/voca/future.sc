import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

def longRunningProcess(x: Int): Int =
  Thread.sleep(3_000)
  x + 42

val ft = Future(longRunningProcess(123))

ft.onComplete(_ -> println("done!"))

println(ft.value)

ft.andThen(_ -> println("and i am happy!"))

println(ft.value)

Thread.sleep(4_000)

println(ft.value)