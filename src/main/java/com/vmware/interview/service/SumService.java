package com.vmware.interview.service;

import com.vmware.interview.constants.ErrorCodeEnum;
import com.vmware.interview.controller.SumController;
import com.vmware.interview.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SumService implements ISumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumController.class);

    @Override
    public String sum(String operandX, String operandY) {
        int result;
        try {
            int opX = Integer.valueOf(operandX);
            int opY = Integer.valueOf(operandY);
            result = opX + opY;
        } catch (NumberFormatException ex) {
            LOGGER.error("Input parameters are not valid numbers", ex);
            throw new ValidationException("Not a valid number", ErrorCodeEnum.VALIDATION_EXCEPTION);
        }
        return String.valueOf(result);
    }
}
