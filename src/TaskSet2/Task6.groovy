package TaskSet2

//def factorial
//factorial = { n, BigInteger acc = 1 ->
//    return n == 1 ? acc : factorial(n - 1, n * acc)
//}
//
//def factorialTrampoline
//factorialTrampoline = { n, BigInteger acc = 1 ->
//    return n == 1 ? acc : factorialTrampoline.trampoline(n - 1, n * acc)
//}.trampoline()
//
//println factorialTrampoline(1000)
//println factorial(1000)

def startTime
def time = { System.currentTimeMillis() - startTime }

def counter = 0
def fibonacci
fibonacci = { n ->
    counter++
    return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2)
}

startTime = System.currentTimeMillis()
fibonacci(25)
println("Time fibonacci: ${time()}, counter: ${counter}")

counter = 0
fibonacci = fibonacci.memoize()
startTime = System.currentTimeMillis()
fibonacci(25)
println("Time fibonacciMemoize: ${time()}, counter: ${counter}")
