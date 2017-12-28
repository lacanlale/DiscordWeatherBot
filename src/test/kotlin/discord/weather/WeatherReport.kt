package discord.weather

/**************************************************************
 * Weather Class for holding data for a single weather report *
 **************************************************************/

data class WeatherReport (val summary : String = "",
                          val precipitation : String = "Precipitation Chance: ",
                          val tempHigh : String = "High: ",
                          val tempLow : String = "Low: ",
                          val humidity : String = "Humidity: ",
                          val windSpeed : String = "Wind Speed: ")