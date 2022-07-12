package com.jwt.controller;

import com.jwt.dto.LoginDTO;
import com.jwt.service.UserAdminService;
import com.jwt.util.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Can.Ru
 */
@Api(tags = "用户权限")
@RestController
@RequestMapping(path = "user")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "获取token")
    public CommonResponse<String> login(@RequestBody LoginDTO loginDTO){
        return CommonResponse.success(userAdminService.login(loginDTO));
    }


    @GetMapping("/getCustomMsg")
    @ApiOperation(value = "getCustomMsg", notes = "getCustomMsg")
    public CommonResponse<String> testToken(){
        return CommonResponse.success(userAdminService.testToken());
    }
}
