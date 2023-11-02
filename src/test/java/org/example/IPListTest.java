package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class IPListTest extends Assert {

    static IPList ipList = new IPList(1,10);
    ArrayList<Long> expected = new ArrayList<>(Arrays.asList(2L,3L,4L,5L,6L,7L,8L,9L));

    @Test
    public void testCountValue() {
        assertEquals(expected , ipList.addressList);
    }

    @Test
    public void arrayNotNull() {
        assertNotNull(ipList.addressList);
    }

}