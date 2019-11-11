package aquarium

fun main() {
    //buildAquiarium()
//    makeFish()
    println("∀∃()→┐∧∨↔")
}

fun buildAquiarium() {
    val myAquarium = Aquarium()
    myAquarium.height = 80
    val smallAquarium = Aquarium(20, 15, 30)

}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}\n Plecostomus: ${pleco.color}")
    shark.eat()
    pleco.eat()
}

