package Buildings

open class BaseBuildingMaterial {
    open val numberNeeded: Int = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 8
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {
    var baseMaterialsNeeded = 100
    var actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} required.")
    }

}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    println(
        if (building.actualMaterialsNeeded < 500) {
            "small building"
        } else {
            "large building"
        }
    )
}

fun main() {
    Building<Wood>(Wood()).build()
    Building<Brick>(Brick()).build()    //800 Brick required
    isSmallBuilding(Building(Brick()))  //large building
}