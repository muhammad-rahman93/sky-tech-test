package uk.co.sky.rest.dto;

import java.io.Serializable;
import java.util.List;

public class ChannelsDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<String> newsChannels;
    private List<String> sportsChannels;

    public ChannelsDto(List<String> newsChannels, List<String> sportsChannels) {
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
