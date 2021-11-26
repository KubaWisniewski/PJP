package TaskSet2

static def apply(List l, Closure c) {
    l.collect(c)
}

def intList = [1, 2, 3, 4, 5, 6]
def charList = ['a', 'b', 'c', 'd', 'e', 'f']

println("(IntList) Mnożenie każdego elemntu razy 2 ${apply(intList, { it * 2 })}")
println("(CharList) Mnożenie każdego elemntu razy 2 ${apply(charList, { it * 2 })}")

println("(IntList) Zwiększenie każdego elemntu o 2 ${apply(intList, { it + 2 })}")
println("(CharList) Zwiększenie każdego elemntu o 2 ${apply(charList, { it + 2 })}")

println("(IntList) Kwadrat każdego elemntu ${apply(intList, { it * it })}")
