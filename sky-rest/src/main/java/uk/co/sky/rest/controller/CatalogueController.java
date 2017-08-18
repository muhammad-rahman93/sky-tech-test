package uk.co.sky.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.co.sky.core.domain.Channels;
import uk.co.sky.core.service.CatalogueService;
import uk.co.sky.rest.adapters.ChannelsAdapter;
import uk.co.sky.rest.dto.ChannelsDto;

@RestController
@RequestMapping("/api")
public class CatalogueController {

    private CatalogueService catalogueService;
    private ChannelsAdapter channelsAdapter;
  
    public CatalogueController(CatalogueService catalogueService, ChannelsAdapter channelsAdapter) {
        this.catalogueService = catalogueService;
        this.channelsAdapter = channelsAdapter;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/channels/", method = RequestMethod.GET)
    public ChannelsDto findChannels(@RequestParam("location") String location) {
        Channels channels = catalogueService.getChannels(location);
        return this.channelsAdapter.adapt(channels);
    }
}
