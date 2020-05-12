package com.vmware.interview.controller;

import com.vmware.interview.model.RequestModel;
import com.vmware.interview.model.ResponseModel;
import com.vmware.interview.service.SumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class SumController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumController.class);

    @Autowired
    private SumService sumService;

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> sum(@NotNull @Validated @RequestBody RequestModel requestModel) {
        LOGGER.info("adding {} and {}", requestModel.getOperandX(), requestModel.getOperandY());
        String result = sumService.sum(requestModel.getOperandX(), requestModel.getOperandY());
        LOGGER.info("result is {}", result);
        ResponseModel responseModel = new ResponseModel(result);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
