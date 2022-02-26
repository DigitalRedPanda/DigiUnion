package com.DigiUnionOfBots.DigiUnion.TwitchBot;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.auth.providers.TwitchIdentityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LaunchBot{
    @Autowired
    private BotInfo info;
    CredentialManager credentialManager = CredentialManagerBuilder.builder().build();
    private OAuth2Credential oAuth2Credential = new OAuth2Credential("twitch",info.getToken());

    public TwitchClient TC(){
        TwitchClient TC = TwitchClientBuilder.builder()
                .withEnableHelix(true)
                .withCommandTrigger(info.getPrefix())
                .withClientSecret(info.getClientSecret())
                .withEnableChat(true)
                .withCredentialManager(credentialManager)
                .withDefaultAuthToken(oAuth2Credential)
                .build();
        credentialManager.registerIdentityProvider(new TwitchIdentityProvider(info.getClientID(),info.getClientSecret(),info.getRedirectURL()));

        return TC;
    }
}
