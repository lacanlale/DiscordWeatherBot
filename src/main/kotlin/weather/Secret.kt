package discord.weather

/********************************************
 * File is usd to store API keys            *
 * Reminder that (in most cases) you are to *
 * not distribute your API key              *
 ********************************************/

data class Secret(val weather: String = "",
                  val discordBot: String = "")