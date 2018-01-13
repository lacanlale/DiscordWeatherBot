package discord.weather

import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

/************************************************
 * Parser class for the JSON values returned    *
 * from darksky.net's output                    *
 ************************************************/

class WeatherJSON constructor(weatherKey:String,
                              latitude:String,
                              longitude:String) {
    /*
     * Simple string builder for the darksky URL
     * Necessary for acquiring JSON data
     */
    private var darkskyFullURL = StringBuilder("https://api.darksky.net/forecast/")
            .append(weatherKey)
            .append("/$latitude,$longitude")

    private var connection = URL(darkskyFullURL.toString()).openConnection() as HttpURLConnection
    private val connectionData = try {
            connection.inputStream?.bufferedReader()?.readText()
        } finally { connection.disconnect() }
    private val jsonDaily: JSONObject = JSONObject(connectionData).getJSONObject("daily")

    /**
     * JSON DATA RETRIEVAL METHODS
     */
    fun getSummary() : String{
        return jsonDaily.getString("summary")
    }
    fun getDetails() : JSONObject {
        val dataArr = jsonDaily.getJSONArray("data")
        return dataArr.getJSONObject(0)
    }
}