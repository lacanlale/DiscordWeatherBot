package discord.weather

class City constructor(private val city: String,
                       private val state: String){
    override fun toString(): String {
        return "$city, $state"
    }
}