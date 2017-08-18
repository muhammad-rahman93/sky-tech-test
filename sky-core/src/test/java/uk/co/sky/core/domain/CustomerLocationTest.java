package uk.co.sky.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CustomerLocationTest {

    @Test
    public void shouldGetLocationOfUser() {
        String location = "London";
        CustomerLocation customerLocation = new CustomerLocation(location);

        assertThat(customerLocation.getLocation(), is(location));
    }
}
