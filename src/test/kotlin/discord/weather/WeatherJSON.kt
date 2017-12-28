package discord.weather

import com.beust.klaxon.JSON
import org.json.JSONObject

/************************************************
 * Parser class for the JSON values returned    *
 * from darksky.net's output. Klaxon is used to *
 * parse the JSON values.                       *
 ************************************************/

class WeatherJSON constructor(keys:Secret = Secret(),
                              latitude:String,
                              longitude:String) {
    private val darkskyWeatherURL: String = "https://api.darksky.net/forecast/"
    private val darkskyWeatherAPI: String = keys.weather

    private var darkskyFullURL:StringBuilder = StringBuilder(darkskyWeatherURL)
            .append(darkskyWeatherAPI)
            .append(",")
            .append(latitude).append(longitude)

    val finalURL: String = darkskyFullURL.toString()
    val urlReply: String? = openLink(finalURL)

    //todo have jsonWeatherData parse the URL reply
    val jsonWeatherData: JSONObject = JSONObject()

    //todo Finish url opener
    fun openLink(url: String): String?{
        return null
    }
}