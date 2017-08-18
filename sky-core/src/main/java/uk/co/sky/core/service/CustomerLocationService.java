package uk.co.sky.core.service;

import java.util.Optional;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.core.exception.CustomerLocationException;

public interface CustomerLocationService {

    public Optional<CustomerLocation> getLocation(String id) throws CustomerLocationException;
}
