package weather

/********************************************
 * File is usd to store API keys            *
 * Reminder that (in most cases) you are to *
 * not distribute your API key              *
 ********************************************/

data class Secret (val darksky: String = "",
                   val discordBot: String = "",
                   val googleGeocoding: String = "")
