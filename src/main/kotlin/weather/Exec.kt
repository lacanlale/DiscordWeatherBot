package discord.weather

/**********************************
 * Main class for running the bot *
 **********************************/

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>){
    var keys = Secret()
    JDABuilder(AccountType.BOT)
            .setToken(keys.discordBot)
            .buildAsync()
            .addEventListener(Bot(keys))
}