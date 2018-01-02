package weather

/*****************************************************************************
 * Works with the JSON output from google's Geocoding API.                   *
 * The class is required for retrieving the latitude/longitude of            *
 * a given city. These two values are required to retrieve a weather report  *
 * from darksky's API.                                                       *
 *****************************************************************************/

import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class CityJSON constructor(city: String,
                           state: String,
                           key: String){
    private val googleGeocodingAPIURL = StringBuilder("https://maps.googleapis.com/maps/api/geocode/")
            .append("json?address=")
            .append("+${city.replace(" ", "+").trim()},")
            .append("+${state.trim()}")
            .append("&key=$key")

    private var connection = URL(googleGeocodingAPIURL.toString()).openConnection() as HttpURLConnection
    private val connectionData = try {
        connection.inputStream?.bufferedReader()?.readText()
    } finally { connection.disconnect() }

    private val jsonCity: JSONObject = JSONObject(connectionData).getJSONArray("results").getJSONObject(0)

    /**Retrieves latitude,longitude JSON coordinates**/
    private val jsonCityCoordinates: JSONObject = jsonCity.getJSONObject("geometry").getJSONObject("location")

    fun getLatitude() : String{
        return jsonCityCoordinates.getDouble("lat").toString()
    }
    fun getLongitude() : String{
        return jsonCityCoordinates.getDouble("lng").toString()
    }
}