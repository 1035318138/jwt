package com.jwt.util;

import com.jwt.dto.LoginDTO;
import com.jwt.dto.TokenVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Can.Ru
 */
public class ExtendParameterHelper {

    private static final Logger log = LoggerFactory.getLogger(ExtendParameterHelper.class);

    //获取ip
    public static String getIp(){
        return LoginAccountSecurity.getRequestIp();
    }

    //获取token信息
    public static String getTokenMsg(){
        return LoginAccountSecurity.getToken();
    }

    //获取自定义封装DTO
    public static TokenVO getDTO() {
        log.info("当前线程:{}", Thread.currentThread().getName());
        return LoginAccountSecurity.getLoginAccountDetail();
    }
}
