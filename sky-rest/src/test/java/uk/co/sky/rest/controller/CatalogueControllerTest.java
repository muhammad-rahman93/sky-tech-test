package uk.co.sky.rest.controller;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.sky.core.domain.Channels;
import uk.co.sky.core.service.CatalogueService;
import uk.co.sky.rest.adapters.ChannelsAdapter;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueControllerTest {

    @Mock
    private CatalogueService catalogueService;

    @Mock
    private ChannelsAdapter channelsAdapter;

    @InjectMocks
    private CatalogueController controller;

    @Test
    public void shouldCallCatalogueServiceToGetProducts() {
        controller.findChannels("London");

        verify(catalogueService, times(1)).getChannels(eq("London"));
    }

    @Test
    public void shouldCallAdapterWhenItHasSomeChannels() {
        when(catalogueService.getChannels("London"))
           .thenReturn(new Channels(Arrays.asList("News Channel"), 
                   Arrays.asList("Sports Channel")));

        controller.findChannels("London");

        verify(channelsAdapter, times(1)).adapt(Mockito.any(Channels.class));
    }
}
