package discord.weather

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>){
    val keys = Secret()
    JDABuilder(AccountType.BOT)
            .setToken(keys.discordBot)
            .buildAsync()
            .addEventListener(Bot(keys))
}