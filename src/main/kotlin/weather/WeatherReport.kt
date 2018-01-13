package weather

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
    private val precipitation = "PRECIPITATION CHANCE: $prec%"
    private val tempHigh = "HIGH: $high F°"
    private val tempLow = "LOW: $low F°"
    private val humidity = "HUMIDITY: $hum %"
    private val windSpeed = "WIND SPEED: $speed MPH"

    /*
     * toString for readable output
     * Method is called by JDA library to print the message to server chat
     *
     * OUTPUT SAMPLE:
     * #~=*☆✧San Francisco✧☆*=~#
     * Light Breeze, partly cloudy with a chance of rain
     * PRECIPITATION CHANCE: 0.6%
     * HIGH: 66 F°
     * LOW: 53 F°
     * HUMIDITY: 15%
     * WIND SPEED: 3 MPH
     */
    override fun toString(): String {
        return """
            |```markdown
            |#~=*☆✧$city✧☆*=~#
            |* $summary
            |* $precipitation
            |* $tempHigh
            |* $tempLow
            |* $humidity
            |* $windSpeed```
            """.trimMargin()
    }
}