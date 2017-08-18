package uk.co.sky.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ChannelsTest {

    private Channels channels;
    private List<String> newsChannels;
    private List<String> sportsChannels;

    @Before
    public void setUp() {
        newsChannels = Arrays.asList("News channel 1", "News channel 2");
        sportsChannels = Arrays.asList("Sports channel 1", "Sports channel 2");

        channels = new Channels(newsChannels, sportsChannels);
    }

    @Test
    public void shouldGetListOfNewsChannels() {
        assertThat(channels.getNewsChannels().get(0), is(newsChannels.get(0)));
        assertThat(channels.getNewsChannels().get(1), is(newsChannels.get(1)));
    }

    @Test
    public void shouldGetListOfSportsChannels() {
        assertThat(channels.getSportsChannels().get(0), is(sportsChannels.get(0)));
        assertThat(channels.getSportsChannels().get(1), is(sportsChannels.get(1)));
    }
}
