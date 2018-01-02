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

    private val weatherReports: ArrayList<WeatherReport> = CityDetails(cityFile, keys.geocoding, keys.weather).getReports()

    //todo implement sending messages of weather report
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.getAuthor().isBot()) return
        val message: Message = event.getMessage()
        val content: String = message.getContentDisplay()
        if (content.equals("Bot! Execute"))
        {
            val channel: MessageChannel = event.getChannel()
            for(report in weatherReports){
                channel.sendMessage(report.toString()).queue()
            }
            channel.sendMessage("Powered by Dark Sky")
        }
    }
}