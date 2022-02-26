package com.DigiUnionOfBots.DigiUnion.DiscordBot.Listeners.GiveawayListener;

import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class GiveawayImplementation implements Giveaway{
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.isPrivateMessage()&&messageCreateEvent.getMessage().getContent().equalsIgnoreCase(""))
    ;
    }
}
