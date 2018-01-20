package weather

/********************************************
 * File is usd to store API keys            *
 * Reminder that (in most cases) you are to *
 * not distribute your API key              *
 ********************************************/

data class Secret (val darksky: String = "8d0fa863587b5af3e72e1af24d22d1d5",
                   val discordBot: String = "MzQ5NTcyODk3MzE4MTA5MTk1.DUR5Kw.DDXc2ycrLo_wJY6Klz1j1IVq99Y",
                   val googleGeocoding: String = "AIzaSyAjQMbVllUtMJ52tJ0Li5ejS2Iu0aPw32I")