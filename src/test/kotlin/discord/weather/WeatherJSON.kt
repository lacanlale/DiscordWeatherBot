package discord.weather

import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

/************************************************
 * Parser class for the JSON values returned    *
 * from darksky.net's output                    *
 ************************************************/

class WeatherJSON constructor(keys:Secret = Secret(),
                              latitude:String,
                              longitude:String) {
    private var darkskyFullURL = StringBuilder("https://api.darksky.net/forecast/")
            .append(keys.weather)
            .append(latitude)
            .append(",")
            .append(longitude)

    private var connection = URL(darkskyFullURL.toString()).openConnection() as HttpURLConnection
    private val connectionData = try {
            connection.inputStream?.bufferedReader()?.readText()
        } finally { connection.disconnect() }

    val jsonDayWeather: JSONObject = JSONObject(connectionData).getJSONObject("daily")

    //todo move weather report into bot class
    val weatherDay: WeatherReport = WeatherReport(
            jsonDayWeather.getString("summary"),
            jsonDayWeather.getString("precipProbability"),
            jsonDayWeather.getString("temperatureHigh"),
            jsonDayWeather.getString("temperatureLow"),
            jsonDayWeather.getString("humidity"),
            jsonDayWeather.getString("windSpeed"))
}