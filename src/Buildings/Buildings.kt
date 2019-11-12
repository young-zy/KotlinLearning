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

class Building<T : BaseBuildingMaterial>(val buildingMaterial: BaseBuildingMaterial) {
    var baseMaterialsNeeded = 100
    var actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} required.")
    }

}

fun main() {
    Building<Wood>(Wood()).build()
}