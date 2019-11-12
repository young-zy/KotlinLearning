package aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

fun main() {
    genericExample()
}

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

//class Aquarium<T>(val waterSupply: T)//T is not bounded and stands for nullable
//class Aquarium<T:Any>(val waterSupply: T)
class Aquarium<T : WaterSupply>(val waterSupply: T) {  //have bounds
    fun addWater() {
        check(!waterSupply.needsProcessed) {
            //throws illegal exception when argument is false
            "water supply needs processed"      //error message
        }
        println("adding water from $waterSupply")
    }
}

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())//bracket can be removed
    aquarium.waterSupply.addChemicalCleaners()


//    val aquarium2:Aquarium<String> = Aquarium("string")//T is not bounded

//    val aquarium3:Aquarium<Nothing?> = Aquarium(null)//can be null if not bounded

    val aquarium4: Aquarium<LakeWater> = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()      //will throw exception if not filtered
    aquarium4.addWater()
}