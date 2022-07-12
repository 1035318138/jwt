package com.jwt.util;

import com.jwt.dto.LoginDTO;
import com.jwt.dto.TokenVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Can.Ru
 */
public class LoginAccountSecurity {

    private static final Logger log = LoggerFactory.getLogger(LoginAccountSecurity.class);

    private static final ThreadLocal<TokenVO> ACCOUNT = new ThreadLocal();
    private static final ThreadLocal<String> REQUEST_IP = new ThreadLocal();
    private static final ThreadLocal<String> TOKEN = new ThreadLocal();

    public LoginAccountSecurity() {
    }

    public static void clean() {
        ACCOUNT.remove();
        TOKEN.remove();
        REQUEST_IP.remove();
    }

    public static TokenVO getLoginAccountDetail() {
        return (TokenVO)ACCOUNT.get();
    }

    public static void setLoginAccountDetail(TokenVO loginAccount) {
        log.info("set当前线程:{}", Thread.currentThread().getName());
        ACCOUNT.set(loginAccount);
    }

    public static String getToken() {
        return (String)TOKEN.get();
    }

    public static void setToken(String token) {
        TOKEN.set(token);
    }

    public static String getRequestIp() {
        return (String)REQUEST_IP.get();
    }

    public static void setRequestIp(String requestIp) {
        REQUEST_IP.set(requestIp);
    }
}
