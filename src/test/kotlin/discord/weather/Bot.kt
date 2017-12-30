package discord.weather

import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class Bot constructor(keys :Secret) : ListenerAdapter(){
    private val weatherAPI = keys.weather
    private val discordBotAPI = keys.discordBot

    private val jsonWeather = WeatherJSON(weatherAPI,"34.0522", "118.2437")
    private val jsonWeatherDetails = jsonWeather.getDetails()

    private val weatherDay: WeatherReport = WeatherReport(
            jsonWeather.getSummary(),
            jsonWeatherDetails.getDouble("precipProbability").toString(),
            jsonWeatherDetails.getDouble("temperatureHigh").toString(),
            jsonWeatherDetails.getDouble("temperatureLow").toString(),
            jsonWeatherDetails.getDouble("humidity").toString(),
            jsonWeatherDetails.getDouble("windSpeed").toString())
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.getAuthor().isBot()) return
        val message: Message = event.getMessage()
        val content: String = message.getContentDisplay()
        if (content.equals("Execute"))
        {
            val channel: MessageChannel = event.getChannel()
            channel.sendMessage(weatherDay.toString()).queue()
        }
    }
}