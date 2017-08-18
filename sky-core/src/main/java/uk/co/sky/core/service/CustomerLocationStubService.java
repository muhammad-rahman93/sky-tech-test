package uk.co.sky.core.service;

import java.util.Optional;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.core.exception.CustomerLocationException;

public class CustomerLocationStubService implements CustomerLocationService{

    @Override
    public Optional<CustomerLocation> getLocation(String id) throws CustomerLocationException {
        //Stub class forced to return London
        CustomerLocation location = new CustomerLocation("London");
        return Optional.of(location);
    }
}
