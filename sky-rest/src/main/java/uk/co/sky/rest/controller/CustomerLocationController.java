package uk.co.sky.rest.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.core.exception.CustomerLocationException;
import uk.co.sky.core.service.CustomerLocationService;
import uk.co.sky.rest.adapters.CustomerLocationAdapter;
import uk.co.sky.rest.dto.CustomerLocationDto;

@RestController
@RequestMapping("/api")
public class CustomerLocationController {

    private CustomerLocationService customerLocationService;
    private CustomerLocationAdapter customerLocationAdapater;

    public CustomerLocationController(CustomerLocationService customerLocationService, CustomerLocationAdapter customerLocationAdapter) {
        this.customerLocationService = customerLocationService;
        this.customerLocationAdapater = customerLocationAdapter;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/location/", method = RequestMethod.GET)
    public CustomerLocationDto findLocation(@RequestParam("id") String id) throws CustomerLocationException {
        Optional<CustomerLocation> customerLocation = customerLocationService.getLocation(id);

        if (customerLocation.isPresent()) {
            return this.customerLocationAdapater.adapt(customerLocation.get());
        }

        throw new CustomerLocationException("Could not find location");
    }
}
