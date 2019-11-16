package aquarium

fun labels() {
    loop@ for (i in 1..100) {         //<identifier>@ [Expression]
        for (j in 1..100) {
            if (i > 10) break@loop
        }
    }
}