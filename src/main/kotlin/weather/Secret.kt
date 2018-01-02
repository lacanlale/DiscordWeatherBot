package discord.weather

/********************************************
 * File is usd to store API keys            *
 * Reminder that (in most cases) you are to *
 * not distribute your API key              *
 ********************************************/

data class Secret constructor (val weather: String = "",
                   val discordBot: String = "",
                   val geocoding: String = "")