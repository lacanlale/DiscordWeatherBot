package discord.weather

/**************************************************************
 * Weather Class for holding data for a single weather report *
 **************************************************************/

class WeatherReport constructor (sum : String,
                          prec : String,
                          high : String = "High: ",
                          low : String = "Low: ",
                          hum : String = "Humidity: ",
                          speed : String = "Wind Speed: "){
    val summary = sum
    val precipitation = "Precipitation Chance: $prec%"
    val tempHigh = "High: $high F°"
    val tempLow = "Low: $low F°"
    val humidity = "Humidity: $hum %"
    val windSpeed = "Wind Speed: $speed MPH"
}