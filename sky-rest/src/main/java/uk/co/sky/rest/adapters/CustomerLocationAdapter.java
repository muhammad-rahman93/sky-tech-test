package uk.co.sky.rest.adapters;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.rest.dto.CustomerLocationDto;

public class CustomerLocationAdapter {

    public CustomerLocationDto adapt(CustomerLocation customerLocation) {
        return new CustomerLocationDto(customerLocation.getLocation());
    }
}
