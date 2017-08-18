package uk.co.sky.core.domain;

import java.util.List;

public class Channels {

    private List<String> newsChannels;
    private List<String> sportsChannels;

    public Channels(List<String> newsChannels,  List<String> sportsChannels) {
        this.newsChannels = newsChannels;
        this.sportsChannels = sportsChannels;
    }

    public List<String> getNewsChannels() {
        return this.newsChannels;
    }

    public List<String> getSportsChannels() {
        return this.sportsChannels;
    }
}
