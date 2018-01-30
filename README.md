# Discord Weather Bot

*This is a discord bot for displaying the weather report daily.*

*Brief Overview:*
The bot will print a weather report of the CURRENT day for *every* city on a given list.
This list is printed in **CITY_NAME, STATE_INITIALS** format, and is recorded on a **CITY_LIST.txt** file, included in this repository.
There are sample cities, however can/should be modified to your desire.
Bot is called by utilizing the **@BOT_NAME: Weather** command, where **BOT_NAME** is a name created by you, the user who added their bot to the server.

This bot does run constantly, meaning when you run the jar, the bot will stay connected until you tell it to leave using the
**@BOT_NAME: Goobye** command or in connection cases where internet connection is lost or the host shuts off.
##### Format for each weather report follows as:
 + Name of the city
 + Summary of the weather for that day
 + Precipitation probability (AKA chance of rain)
 + Highest temperature for that day (in Fahrenheit)
 + Lowest temperature for that day (in Fahrenheit)
 + Humidity percentage
 + Wind speed (in MPH)
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/discord%20ss.png)
##### Utilizes:
- JDA (Java Discord API) for Discord interaction
- darksky.net API for weather forecasts
- Google geocoding for city latitude/longitude retrieval

## How to Install onto your own server
**!!BEFORE INSTALLING, YOU MUST HAVE THE FOLLOWING!!**
+ A Discord account
+ Permissions to manage the server that you want to add the bot to
+ Internet connection
+ A Google Geocoding API key which can be obtained at https://developers.google.com/maps/documentation/geocoding/start
+ A darksky API key which can be obtained at https://darksky.net/dev

### To begin, you must have a bot added to your server.

1. Create the application at https://discordapp.com/developers/applications/me
2. Name the bot however you want. Keep note of the bots name, as it will be necessary for proper installation
3. Click **Create App**
4. After creation, locate the **Create Bot User**. This option is under the app description.
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/Create%20a%20Bot%20User.png)
### Add the new bot to your server
1. Locate the *App details* box at the top of the page
2. Find the field named *Client ID:*
3. You will need this ID for adding your bot. Simply take the ID and paste it into this URL:

' https://discordapp.com/api/oauth2/authorize?client_id=YOURCLIENTIDHERE&scope=bot '
>Note: YOURCLIENTIDHERE in the URL is to be replaced by the Client ID you have.
4. Open the URL after you have placed your client ID within it
5. Select your desired server and click **Authorize**

### Add your API keys
1. From the same Application page where the **Client ID** was found, navigate to where you clicked **Create Bot User** which is under the Application description
2. You should notice that there is a *Bot* box present with a **Token** attribute
3. Click on the *Click to reveal* property and take note of the given token. You can save this to a file or write it down, as you will be moving it along with your other 2 API keys soon.
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/discord%20api.png)
4. Now open your darksky account at https://darksky.net/dev/account and take note of that API key located within the *Your Secret Key* box
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/darksky.png)
5. After taking note, redirect yourself to your Google geocoding account at https://developers.google.com/maps/documentation/geocoding/start and select the *Get a key* option
>Note: Google requires that you create a project for a key. Simply create a project, name it as you like, and take note of the key given.
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/geocoding.png)
After all three keys have been recorded, navigate to the Secret.kt file following this path:
>/home/USER/DiscordWeatherBot/src/main/kotlin/weather/Secret.kt

and copy and paste each key into their appropriate field.
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/Secret.png)
### Finishing details
The installation process is nearly complete, however the final details remaining are the bots name and the cities.
1. Navigate to the Bot.kt file following this path:
> /home/USER/DiscordWeatherBot/src/main/kotlin/weather/Bot.kt
2. There is an empty field labled **botName**. Insert your botName into these quotes.
3. Finally, navigate to the **CITY_LIST.txt** file by following this path
> /home/USER/DiscordWeatherBot/CITY_LIST.txt
4. Modify this list with the desired cities. Be sure to follow the sample format, as it is crucial for the program when reading the cities.
![alt text](https://raw.githubusercontent.com/lacanlale/DiscordWeatherBot/master/README%20IMAGES/City%20List.png)
### Running Bot
WIP

#### License
 + Project is under the MIT License
