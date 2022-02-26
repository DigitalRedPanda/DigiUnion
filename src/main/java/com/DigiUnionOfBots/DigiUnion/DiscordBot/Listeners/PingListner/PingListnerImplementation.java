package com.DigiUnionOfBots.DigiUnion.DiscordBot.Listeners.PingListner;

import com.DigiUnionOfBots.DigiUnion.DiscordBot.Methods.StopWatch;
import lombok.SneakyThrows;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PingListnerImplementation implements PingListner{

    @SneakyThrows
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessage().getContent().equalsIgnoreCase("!getping")){
            messageCreateEvent.getChannel().type();
            stopWatch.start();
            messageCreateEvent.getChannel().sendMessage("**Pong**");
            stopWatch.stop();
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .addField("Delay",String.format("This message took around %.3f seconds",(double) stopWatch.getElapsedTime()/1000))
                            .setFooter(messageCreateEvent.getApi().getOwner().get().getDisplayName(messageCreateEvent.getServer().get()), String.valueOf(messageCreateEvent.getApi().getOwner().get().getAvatar().getUrl()))
                    )
                    .send(messageCreateEvent.getChannel());
        }

    }

    @Autowired
    private StopWatch stopWatch;
}

