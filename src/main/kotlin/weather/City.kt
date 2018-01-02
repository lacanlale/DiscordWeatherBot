package weather

/**********************************************
 * City class for holding city name and state *
 **********************************************/

class City constructor(val city: String,
                       val state: String){
    override fun toString(): String {
        return "$city, $state"
    }
}