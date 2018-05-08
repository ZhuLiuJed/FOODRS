package com.dzh.foodrs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@RunWith(SpringRunner.class)
@SpringBootTest  
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
    private MockMvc mvc;

    @Test
    public void getStudentList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/user/register")
        		.param("username", "kkkkkkk")
        		.param("nickname", "jedaaaajed")
        		.param("password", "1234567")
        		.param("rpassword", "1234567")
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()) //测试接口返回内容
        		.andDo(print());
    }
}
