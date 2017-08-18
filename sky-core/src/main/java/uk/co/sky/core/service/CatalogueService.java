package uk.co.sky.core.service;

import java.util.Arrays;
import java.util.List;

import uk.co.sky.core.domain.Channels;

public class CatalogueService {

    private List<String> emptySportChannels;
    private List<String> londonSportsChannels;
    private List<String> liverpoolSportsChannels;
    private List<String> newsChannels;

    public CatalogueService() {
        this.emptySportChannels = Arrays.asList();
        this.londonSportsChannels = Arrays.asList("Arsenal TV", "Chelsea TV");
        this.liverpoolSportsChannels = Arrays.asList("Liverpool TV");
        this.newsChannels = Arrays.asList("Sky News", "Sky Sports News");
    }

    public Channels getChannels(String location) {
        List<String> sportsChannels = emptySportChannels;

        if (location.equalsIgnoreCase("London")) {
            sportsChannels = londonSportsChannels;
        }

        if(location.equalsIgnoreCase("Liverpool")) {
            sportsChannels = liverpoolSportsChannels;
        }

        Channels channels = new Channels(newsChannels, sportsChannels);

        return channels;
    }
}
