package com.vmware.interview.service;

import com.vmware.interview.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SumServiceTest {

    @Autowired
    SumService sumService;

    @Test
    public void testValidResult() {
        Assert.assertEquals("150", sumService.sum("100", "50"));
    }

    @Test(expected = ValidationException.class)
    public void testInvalidData() {
        sumService.sum("junk", "20");
    }

    @Test(expected = ValidationException.class)
    public void testEmptyData() {
        sumService.sum("", "20");
    }
}