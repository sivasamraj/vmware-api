package com.vmware.interview.service;

import com.vmware.interview.constants.ErrorCodeEnum;
import com.vmware.interview.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DifferenceService implements IDifferenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DifferenceService.class);

    @Override
    public String diff(String operandX, String operandY) {
        int result;
        try {
            int opX = Integer.valueOf(operandX);
            int opY = Integer.valueOf(operandY);
            result = opX - opY;
        } catch (NumberFormatException ex) {
            LOGGER.error("Input parameters are not valid numbers", ex);
            throw new ValidationException("Not a valid number", ErrorCodeEnum.VALIDATION_EXCEPTION);
        }
        return String.valueOf(result);
    }
}
