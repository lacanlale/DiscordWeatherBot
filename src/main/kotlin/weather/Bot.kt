package weather

/************************************************************************************
 * Bot class. Responsible for sending the actual weather report to the discord chat *
 ************************************************************************************/

import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

import java.io.File

class Bot constructor(keys :Secret) : ListenerAdapter(){
    /** IF THE FILE NAME HAS BEEN MODIFIED, ENTER THE CHANGE HERE. INCLUDE EXTENSION**/
    private val fileName = "CITY_LIST.txt"
    private val cityFile = File("$fileName")

    private val weatherReports: ArrayList<WeatherReport> = CityDetails(cityFile, keys.googleGeocoding, keys.darksky).getReports()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot()) return
        val message: Message = event.message
        val content: String = message.contentDisplay
        val channel: MessageChannel = event.channel
        if (content == ("Bot: Weather")) {
            for(report in weatherReports){
                channel.sendMessage(report.toString()).queue()
            }
            channel.sendMessage("`Powered by Dark Sky`").queue()
        }
        if(content == ("Bot: Goodbye")){
            channel.sendMessage("Shutting down. Goodbye!").queue()
            return
        }
    }
}