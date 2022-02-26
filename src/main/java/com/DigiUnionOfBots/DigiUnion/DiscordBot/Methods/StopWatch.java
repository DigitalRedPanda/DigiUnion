package com.DigiUnionOfBots.DigiUnion.DiscordBot.Methods;

import org.springframework.stereotype.Component;

@Component
public class StopWatch{

    private long startTime;

    private long stopTime;

    public StopWatch(){
        this.startTime=System.currentTimeMillis();
    }

    public long getStartTime(){
        return this.startTime;
    }

    public long getStopTime(){
        return this.stopTime;
    }

    public void start(){
        this.startTime=System.currentTimeMillis();
    }

    public void stop(){
        this.stopTime= System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return getStopTime()-getStartTime();
    }
}
