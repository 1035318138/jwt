package com.jwt.service;

import com.jwt.dto.LoginDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Can.Ru
 */

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminServiceTest {

    @Autowired
    private UserAdminService userAdminService;

    @Test
    public void queryUserTest1(){
        String token = userAdminService.login(LoginDTO.builder().userName("admin").password("admin").build());
        Assert.assertNotNull("token不能为空",token);
    }
}
