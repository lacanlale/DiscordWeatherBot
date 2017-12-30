package discord.weather

/**************************************************************
 * Weather Class for holding data for a single weather report *
 **************************************************************/

class WeatherReport constructor (sum: String,
                          prec: String,
                          high: String,
                          low: String,
                          hum: String,
                          speed: String){
    private val summary = sum
    private val precipitation = "Precipitation Chance: $prec%"
    private val tempHigh = "High: $high F°"
    private val tempLow = "Low: $low F°"
    private val humidity = "Humidity: $hum %"
    private val windSpeed = "Wind Speed: $speed MPH"

    override fun toString(): String {
        return """
            |$summary
            |$precipitation
            |$tempHigh
            |$tempLow
            |$humidity
            |$windSpeed
            """.trimMargin()
    }
}