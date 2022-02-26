package com.DigiUnionOfBots.DigiUnion.TwitchBot;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import org.springframework.stereotype.Component;

@Component
public class BotInfo {
private Dotenv dotenv = new DotenvBuilder()
        .directory("src\\main\\resources\\static")
        .filename("Twitch.env")
        .load();
private String Token = dotenv.get("TOKEN");
private String ClientID = dotenv.get("CLIENT_ID");
private String ClientSecret = dotenv.get("CLIENT_SECRET");
private String SpecialChannel = dotenv.get("SPECIAL_CHANNEL");
private String SpecialGuest = dotenv.get("SPECIAL_GUEST");
private String RedirectURL = dotenv.get("REDIRECT_URL");
private String Prefix = dotenv.get("PREFIX");
String getToken(){
    return this.Token;
}
String getClientID(){
    return this.ClientID;
}
String getClientSecret(){
    return this.ClientSecret;
}
String getRedirectURL(){
    return this.RedirectURL;
}
String getSpecialChannel(){
    return this.SpecialChannel;
}
String getSpecialGuest(){
    return this.SpecialGuest;
}
String getPrefix(){
    return this.Prefix;
}
}
