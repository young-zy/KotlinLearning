package aquarium

class Shark : AquariumFish(), FishAction {
    override fun eat() {
        println("hunt and eat fish")
    }

    override val color = "gray"
}

class Plecostomus(fishcolor: FishColor = GoldColor) :
    FishColor by GoldColor,
    FishAction by PrintingFishAction("a lot of algae") // interface delegation

object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

