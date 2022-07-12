package com.jwt.simplefilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwt.dto.TokenVO;
import com.jwt.exception.ErrorCode;
import com.jwt.util.JWTUtil;
import com.jwt.util.LoginAccountSecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Can.Ru
 */
@Component
public class JwtFilter implements HandlerInterceptor {

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = jwtUtil.validateToken(token);
        }catch (Exception e){
            throw new ErrorCode("token validate failed");
        }
        if(claimsJws !=null){
            TokenVO vo = JSON.toJavaObject(JSONObject.parseObject(claimsJws.getBody().get("sub").toString()), TokenVO.class);
            LoginAccountSecurity.setLoginAccountDetail(vo);
            return true;
        }
        response.sendRedirect("https://www.baidu.com");//登录页面
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
