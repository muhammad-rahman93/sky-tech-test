package uk.co.sky.rest.adapters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import uk.co.sky.core.domain.Channels;
import uk.co.sky.rest.dto.ChannelsDto;

public class ChannelsAdapaterTest {

    private Channels channels;
    private ChannelsAdapter channelsAdapter = new ChannelsAdapter();

    @Before
    public void setUp() {
        channels = new Channels(Arrays.asList("News Channel"), Arrays.asList("Sports Channel"));
    }

    @Test
    public void shouldAdaptNewsChannels() {
        ChannelsDto channelsDto = channelsAdapter.adapt(channels);

        assertThat(channelsDto.getNewsChannels().get(0), is(channels.getNewsChannels().get(0)));
    }

    @Test
    public void shouldAdaptSportsChannels() {
        ChannelsDto channelsDto = channelsAdapter.adapt(channels);

        assertThat(channelsDto.getSportsChannels().get(0), is(channels.getSportsChannels().get(0)));
    }
}
