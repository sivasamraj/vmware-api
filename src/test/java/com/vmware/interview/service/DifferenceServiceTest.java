package com.vmware.interview.service;

import com.vmware.interview.exception.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DifferenceServiceTest {

    @Autowired
    DifferenceService differenceService;

    @Test
    public void testDiff() {
        assertEquals("50", differenceService.diff("100", "50"));
    }

    @Test(expected = ValidationException.class)
    public void testInvalidData() {
        differenceService.diff("junk", "20");
    }

    @Test(expected = ValidationException.class)
    public void testEmptyData() {
        differenceService.diff("", "20");
    }
}