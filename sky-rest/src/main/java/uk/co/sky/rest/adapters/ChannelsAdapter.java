package uk.co.sky.rest.adapters;


import uk.co.sky.core.domain.Channels;
import uk.co.sky.rest.dto.ChannelsDto;

public class ChannelsAdapter {

    public ChannelsDto adapt(Channels channels) {
        return new ChannelsDto(channels.getNewsChannels(), channels.getSportsChannels());
    }
}
