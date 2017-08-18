package uk.co.sky.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import uk.co.sky.core.domain.Channels;

public class CatalogueServiceTest {

    private CatalogueService service = new CatalogueService();

    @Test
    public void shouldGetChannelsForLondon() {
        Channels channels = service.getChannels("london");

        assertThat(channels.getSportsChannels().size(), is(2));
        assertThat(channels.getNewsChannels().size(), is(2));
    }

    @Test
    public void shouldGetChannelsForLiverpool() {
        Channels channels = service.getChannels("liverpool");

        assertThat(channels.getSportsChannels().size(), is(1));
        assertThat(channels.getNewsChannels().size(), is(2));
    }

    @Test
    public void shouldGetChannelsForOther() {
        Channels channels = service.getChannels("other");

        assertThat(channels.getSportsChannels().size(), is(0));
        assertThat(channels.getNewsChannels().size(), is(2));
    }
}
