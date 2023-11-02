package org.example;

import org.junit.*;

public class IPv4AddressTest extends Assert{

    static IPv4Address address = new IPv4Address("0.0.0.10");

    @Test
    public void fieldValue() {
        assertEquals(10, address.decimalAddress);
        assertEquals("0.0.0.10", address.normalAddress);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        new IPv4Address("0.");
        new IPv4Address(-1);
        new IPv4Address(null);
    }

}