package TaskSet2

static def maximum(list) {
    def indexes = []
    def maxValue = list.max()

    list.eachWithIndex { entry, index ->
        if (entry == maxValue) indexes << index
    }
    return [maxValue, indexes]
}

(maxVal, indList) = maximum([5, 3, 5, 5, 1, 5])
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"
