package TaskSet2

static def eachTuple(Object iterable, Closure closure) {
    iterable.toList().collate(closure.maximumNumberOfParameters).each { closure(it) }
}

def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) { a, b ->
    out << b << a
}
println out
