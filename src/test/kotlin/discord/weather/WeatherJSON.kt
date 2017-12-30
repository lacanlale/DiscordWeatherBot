package discord.weather

import com.sun.jna.StringArray
import jdk.nashorn.internal.runtime.JSONListAdapter
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Array
import java.net.HttpURLConnection
import java.net.URL

/************************************************
 * Parser class for the JSON values returned    *
 * from darksky.net's output                    *
 ************************************************/

class WeatherJSON constructor(weatherKey:String,
                              latitude:String,
                              longitude:String) {
    private var darkskyFullURL = StringBuilder("https://api.darksky.net/forecast/")
            .append(weatherKey)
            .append("/$latitude,$longitude")

    private var connection = URL(darkskyFullURL.toString()).openConnection() as HttpURLConnection
    private val connectionData = try {
            connection.inputStream?.bufferedReader()?.readText()
        } finally { connection.disconnect() }
    private val jsonDaily: JSONObject = JSONObject(connectionData).getJSONObject("daily")

    fun getSummary() : String{
        return jsonDaily.getString("summary")
    }
    fun getDetails() : JSONObject {
        val dataArr = jsonDaily.getJSONArray("data")
        return dataArr.getJSONObject(0)
    }
}