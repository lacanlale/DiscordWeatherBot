package weather

/**********************************
 * Main class for running the bot *
 **********************************/

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>){
    val keys = Secret()
    if(keys.discordBot.length != 59) println("DISCORD API KEY DOES NOT MEET CORRECT FORMAT. PLEASE FIX")
    else if(keys.darksky.length != 32) println("DARKSKY API KEY DOES NOT MEET CORRECT FORMAT. PLEASE FIX")
    else if(keys.googleGeocoding.length != 39) println("GOOGLE GEOCODING API KEY DOES NOT MEET CORRECT FORMAT. PLEASE FIX")
    else {
        JDABuilder(AccountType.BOT)
                .setToken(keys.discordBot)
                .buildAsync()
                .addEventListener(Bot(keys))
    }
}