# Discord Weather Bot

*This is a discord bot for displaying the weather report daily.*

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
### Add the new bot to your server
1. Locate the *App details* box at the top of the page
2. Find the field named *Client ID:*
3. You will need this ID for adding your bot. Simply take the ID and paste it into this URL:

' https://discordapp.com/api/oauth2/authorize?client_id=YOURCLIENTIDHERE&scope=bot '
>Note: YOURCLIENTIDHERE in the URL is to be replaced by the Client ID you have.
4. Open the URL after you have placed your client ID within it
5. Select your desired server and click **Authorize**

### Add your API keys
WIP

##### Format for each weather report follows as:
 + Name of the city
 + Summary of the weather for that day
 + Precipitation probability (AKA chance of rain)
 + Highest temperature for that day (in Fahrenheit)
 + Lowest temperature for that day (in Fahrenheit)
 + Humidity percentage
 + Wind speed (in MPH)

##### Utilizes:
- JDA (Java Discord API) for Discord interaction
- darksky.net API for weather forecasts
- Google geocoding for city latitude/longitude retrieval

#### License
 + Project is under the MIT License
