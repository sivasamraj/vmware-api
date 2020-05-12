package com.vmware.interview.controller;

import com.vmware.interview.model.RequestModel;
import com.vmware.interview.service.SumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SumService sumService;

    @Test
    public void testSecurity() throws Exception {
        when(sumService.sum(anyString(), anyString())).thenReturn("100");

        RequestModel requestModel = new RequestModel("50", "50");
        MvcResult mvcResult = mockMvc.perform(post("/api/add", requestModel))
                .andExpect(status().isUnauthorized()).andReturn();
    }
}
