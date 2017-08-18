package uk.co.sky.rest.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CustomerLocationDtoTest {

    @Test
    public void shouldGetLocationOfUser() {
        String location = "London";
        CustomerLocationDto customerLocationDto = new CustomerLocationDto(location);

        assertThat(customerLocationDto.getLocation(), is(location));
    }
}
