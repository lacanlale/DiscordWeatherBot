package weather

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
    //Simple string necessary for utilizing the correct API URL
    private val darkskyFullURL = "https://api.darksky.net/forecast/$weatherKey/$latitude,$longitude"

    private val connection:HttpURLConnection = URL(darkskyFullURL).openConnection() as HttpURLConnection
    private val connectionData: String? = try {
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