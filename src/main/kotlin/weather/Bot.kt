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

    /********************************************************
     * THIS IS THE BOT NAME THAT YOU HAVE IN YOUR SERVER.   *
     * YOU MUST SET THE ACTUAL BOT NAME OR IT WILL NOT WORK *
     ********************************************************/
    private val botName = ""

    private val weatherReports: ArrayList<WeatherReport> = CityDetails(cityFile, keys.googleGeocoding, keys.darksky).getReports()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot()) return
        val message: Message = event.message
        val content: String = message.contentDisplay
        val channel: MessageChannel = event.channel

        when (content){
            "@$botName: Weather" -> {
                var report = StringBuilder("```markdown")
                        .append("\n")
                for(weather in weatherReports){
                    report.append("$weather\n\n")
                }
                channel.sendMessage(report.append("Powered by Dark Sky\n```").toString()).queue()
            }
            "@$botName: Goodbye" -> {
                channel.sendMessage("Shutting down. Goodbye!").queue()
                return
            }
            "@$botName: Commands" -> {
                //TODO DOES NOT ACTUALLY EXIT. FIX
                channel.sendMessage("""
                |Possible commands are:
                |\"Weather\" for a weather report of each city on the CITY_LIST.txt
                |\"Goodbye\" to end my connection
                """.trimMargin()).queue()
            }
            "@$botName: Help" -> {
                channel.sendMessage("""
                |Possible commands are:
                |\"Weather\" for a weather report of each city on the CITY_LIST.txt
                |\"Goodbye\" to end my connection
                """.trimMargin()).queue()
            }
        }
    }
}