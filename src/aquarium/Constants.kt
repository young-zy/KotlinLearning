package aquarium

const val rocks = 3 // determines at compile time

val number = 5 //determines at runtime

class MyClass {
    companion object { //initialized at static constructor(when object is created)
        const val CONSTANT = "constant inside companion"   //wrap constants inside class in companion object
    }
    //others initialize on the first access(first used)
}