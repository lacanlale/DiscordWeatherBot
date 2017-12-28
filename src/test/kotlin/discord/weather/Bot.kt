package discord.weather

import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class Bot constructor(keys :Secret) : ListenerAdapter(){
    val weatherAPI = keys.weather
    val discordBotAPI = keys.discordBot

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.getAuthor().isBot()) return
        val message: Message = event.getMessage()
        val content: String = message.getContentDisplay()
        if (content.equals("!halp"))
        {
            val channel: MessageChannel = event.getChannel()
            channel.sendMessage("no!").queue()
        }
    }
}