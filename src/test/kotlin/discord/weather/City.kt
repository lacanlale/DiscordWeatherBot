package discord.weather

class City constructor(val city: String,
                       val state: String){
    override fun toString(): String {
        return "$city, $state"
    }
}