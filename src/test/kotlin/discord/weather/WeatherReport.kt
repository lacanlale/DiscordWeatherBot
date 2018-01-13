package discord.weather

/**************************************************************
 * Weather Class for holding data for a single weather report *
 **************************************************************/

class WeatherReport constructor (city: City,
                                 sum: String,
                                 prec: String,
                                 high: String,
                                 low: String,
                                 hum: String,
                                 speed: String){
    private val city = city
    private val summary = sum
    private val precipitation = "Precipitation Chance: $prec%"
    private val tempHigh = "High: $high F°"
    private val tempLow = "Low: $low F°"
    private val humidity = "Humidity: $hum %"
    private val windSpeed = "Wind Speed: $speed MPH"


    /*
     * toString for readable output
     * Method is called by JDA library to print the message to server chat
     *
     * OUTPUT SAMPLE:
     * :･ﾟ☆✧San Francisco✧☆ﾟ･:
     * Light Breeze, partly cloudy with a chance of rain
     * Precipitation Chance: 0.6%
     * High: 66 F°
     * Low: 53 F°
     * Humidity: 15%
     * Wind Speed: 3 MPH
     */
    override fun toString(): String {
        return """
            |:･ﾟ☆✧$city✧☆ﾟ･:
            |$summary
            |$precipitation
            |$tempHigh
            |$tempLow
            |$humidity
            |$windSpeed
            """.trimMargin()
    }
}