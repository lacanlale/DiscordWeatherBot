package discord.weather

import org.json.JSONObject
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

/*********************************************************
 * Primary class for dealing with reading the            *
 * city list file. Will also process the weather reports *
 * into an array.                                        *
 *********************************************************/
class CityDetails constructor(file: File,
                              geocodingKey: String,
                              weatherKey: String){
    private val geocodingKey = geocodingKey
    private val weatherKey = weatherKey

    private val cityList = readFile(file)

    private fun readFile(file: File) : ArrayList<City>{
        var locations: ArrayList<City> = ArrayList()
        try{
            val scanner = Scanner(file)
            var cityState: List<String>
            var newLocation: City
            while(scanner.hasNext()){
                cityState = scanner.nextLine().trim().replace(" +", " ").split(",")
                newLocation = City(cityState[0], cityState[1])
                locations.add(newLocation)
            }
        }
        catch (e: FileNotFoundException){
            e.printStackTrace()
        }
        return locations
    }
    fun getReports(): ArrayList<WeatherReport>{
        var reports: ArrayList<WeatherReport> = ArrayList()

        var cityJson: CityJSON
        var lat: String
        var lng: String
        var weatherJson: WeatherJSON
        var weatherJsonDetails: JSONObject
        var weatherReport: WeatherReport

        for(city in cityList){
            cityJson = CityJSON(city.city, city.state, geocodingKey)
            lat = cityJson.getLatitude()
            lng = cityJson.getLongitude()
            weatherJson = WeatherJSON(weatherKey, lat, lng)
            weatherJsonDetails = weatherJson.getDetails()
            weatherReport = WeatherReport(
                    city,
                    weatherJson.getSummary(),
                    weatherJsonDetails.getDouble("precipProbability").toString(),
                    weatherJsonDetails.getDouble("temperatureHigh").toString(),
                    weatherJsonDetails.getDouble("temperatureLow").toString(),
                    weatherJsonDetails.getDouble("humidity").toString(),
                    weatherJsonDetails.getDouble("windSpeed").toString())

            reports.add(weatherReport)
        }

        return reports
    }
}