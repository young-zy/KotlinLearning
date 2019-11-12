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
class Aquarium<out T : WaterSupply>(val waterSupply: T) {  //have bounds
    //out types can only be passed out of an object or as return value
    fun addWater(cleaner: Cleaner<T>) {
        if (!waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
            //throws illegal exception when argument is false
            println("water supply needs processed")     //error message
        }
        println("adding water from $waterSupply")
    }
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

//constructors can take out types as parameters
//but functions never can


interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}
//in types can only be passed into an object

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())//bracket can be removed
    aquarium.waterSupply.addChemicalCleaners()

//    val aquarium2:Aquarium<String> = Aquarium("string")//T is not bounded

//    val aquarium3:Aquarium<Nothing?> = Aquarium(null)//can be null if not bounded
    val cleaner2 = TapWaterCleaner()
    val aquarium4: Aquarium<LakeWater> = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()      //will throw exception if not filtered
//    aquarium4.addWater()
//    addItemTo(aquarium)     //will get compiler error if not declared as out

    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)

    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>()   //true
    aquarium.waterSupply.isOfType<LakeWater>()  //false
}