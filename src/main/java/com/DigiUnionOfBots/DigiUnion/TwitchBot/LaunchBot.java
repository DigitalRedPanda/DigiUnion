package com.DigiUnionOfBots.DigiUnion.TwitchBot;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LaunchBot{
    @Autowired
    private BotInfo info;
    TwitchClient TC = TwitchClientBuilder.builder()
            .withEnableHelix(true)
            .withCommandTrigger(info.getPrefix())
            .withClientSecret(info.getClientSecret())
            .withChatAccount()
            .withCredentialManager()
            .build();
}
