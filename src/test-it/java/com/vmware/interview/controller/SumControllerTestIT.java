package com.vmware.interview.controller;

import com.vmware.interview.model.RequestModel;
import com.vmware.interview.model.ResponseModel;
import com.vmware.interview.service.SumService;
import com.vmware.interview.model.BaseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SumControllerTestIT {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Autowired
    private SumService sumService;


    @Test
    public void testOk() {

        RequestModel requestModel = new RequestModel("10", "10");
        ResponseEntity responseEntity = testRestTemplate
                .withBasicAuth("user", "password")
                .postForEntity("/add", requestModel, ResponseModel.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        ResponseModel responseModel = (ResponseModel) responseEntity.getBody();
        assertThat(responseModel.getResult().equals("20")).isTrue();
    }

    @Test
    public void testEmptyValue() {

        RequestModel requestModel = new RequestModel("", "10");
        ResponseEntity responseEntity = testRestTemplate
                .withBasicAuth("user", "password")
                .postForEntity("/add", requestModel, BaseModel.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        BaseModel baseModel = (BaseModel) responseEntity.getBody();
        assertThat(baseModel.getErrors().get(0).getId().equals("3000")).isTrue();
    }

    @Test
    public void testInvalidValue() {

        RequestModel requestModel = new RequestModel("junk", "10");
        ResponseEntity responseEntity = testRestTemplate
                .withBasicAuth("user", "password")
                .postForEntity("/add", requestModel, BaseModel.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        BaseModel baseModel = (BaseModel) responseEntity.getBody();
        assertThat(baseModel.getErrors().get(0).getId().equals("3000")).isTrue();
    }
}
