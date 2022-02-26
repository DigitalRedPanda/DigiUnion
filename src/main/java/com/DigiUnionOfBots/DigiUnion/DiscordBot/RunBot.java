package com.DigiUnionOfBots.DigiUnion.DiscordBot;


import com.DigiUnionOfBots.DigiUnion.DiscordBot.Listeners.PingListner.PingListner;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class RunBot {

    @Autowired
    private Environment env;

    @Autowired
    private PingListner pingListner;


    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordClient(){
        String Token = env.getProperty("TOKEN");
        DiscordApi client = new DiscordApiBuilder().setToken(Token)
                .login()
                .join();
        client.addMessageCreateListener(pingListner);

        return client;
    }

}
