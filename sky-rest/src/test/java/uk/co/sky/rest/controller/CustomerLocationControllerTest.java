package uk.co.sky.rest.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.core.exception.CustomerLocationException;
import uk.co.sky.core.service.CustomerLocationService;
import uk.co.sky.rest.adapters.CustomerLocationAdapter;

@RunWith(MockitoJUnitRunner.class)
public class CustomerLocationControllerTest {

    @Mock
    private CustomerLocationService customerLocationService;

    @Mock
    private CustomerLocationAdapter customerLocationAdapter;

    @InjectMocks
    private CustomerLocationController controller;

    @Before
    public void setUp() throws CustomerLocationException {
        when(customerLocationService.getLocation("test"))
        .thenReturn(Optional.of(new CustomerLocation("London")));
    }

    @Test
    public void shouldCallCustomerLocationService() throws CustomerLocationException {
        controller.findLocation("test");

        verify(customerLocationService, times(1)).getLocation("test");
    }

    @Test
    public void shouldCallCustomerLocationAdpaterWhenItHasOptional() throws CustomerLocationException {
        controller.findLocation("test");

        verify(customerLocationAdapter, times(1)).adapt(Mockito.any(CustomerLocation.class));
    }

    @Test(expected = CustomerLocationException.class)
    public void shouldThrowExceptionWhenOptionalIsEmpty() throws CustomerLocationException {
        when(customerLocationService.getLocation("test"))
        .thenReturn(Optional.empty());

        controller.findLocation("test");
    }
}
