package uk.co.sky.rest.adapters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import uk.co.sky.core.domain.CustomerLocation;
import uk.co.sky.rest.dto.CustomerLocationDto;

public class CustomerLocationAdapterTest {

    private CustomerLocationAdapter adapater = new CustomerLocationAdapter();

    @Test
    public void shouldAdaptLocationfromDomainToDto() {
        String location = "London";
        CustomerLocation customerLocation = new CustomerLocation(location);

        CustomerLocationDto customerDto = adapater.adapt(customerLocation);

       assertThat(customerDto.getLocation(), is(customerLocation.getLocation()));
    }
}
