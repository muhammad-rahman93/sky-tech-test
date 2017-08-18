package uk.co.sky.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import uk.co.sky.core.exception.CustomerLocationException;

public class CustomerLocationStubServiceTest {

    @Test
    public void shouldReturnLondonForStub() throws CustomerLocationException {
        CustomerLocationService customerLocationStubService = new CustomerLocationStubService();
        assertThat(customerLocationStubService.getLocation("other").get().getLocation(), is("London"));
    }
}
