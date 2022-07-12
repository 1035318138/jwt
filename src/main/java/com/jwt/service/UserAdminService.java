package com.jwt.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.jwt.dto.LoginDTO;
import com.jwt.dto.TokenVO;
import com.jwt.entity.User;
import com.jwt.exception.ErrorCode;
import com.jwt.util.ExtendParameterHelper;
import com.jwt.util.JWTUtil;
import com.jwt.util.LoginAccountSecurity;
import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;


/**
 * @author Can.Ru
 */
@Service
public class UserAdminService {

    public static String tableName = "t_user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private JWTUtil jwtUtil;

    public String login(LoginDTO loginDTO){
        User user = getLoginUserInfo(loginDTO.getUserName());
        verifyUser(loginDTO,user);
        List<Integer> roles = userRoleService.getUserRoleList(user.getId());
        TokenVO tokenVO = TokenVO.builder().id(user.getId()).name(user.getName()).roles(roles).build();
        String token = jwtUtil.createToken(tokenVO);
        //模拟上下文方便存取
        LoginAccountSecurity.setLoginAccountDetail(tokenVO);
        //LoginAccountSecurity.setRequestIp();
        return token;
    }

    private User getLoginUserInfo(String userName) {
        SQL sql = new SQL().SELECT("*").FROM(tableName).WHERE(User.NAME);
        Object[] param = new Object[]{userName};
        return jdbcTemplate.queryForObject(sql.toString(), param, new BeanPropertyRowMapper<User>(User.class));
    }


    private void verifyUser(LoginDTO loginDTO, User user){
        if(!Objects.nonNull(loginDTO.getPassword()) || !StringUtils.equals(loginDTO.getPassword(),user.getPassword())){
            throw new RuntimeException("password verify failed");
        }
    }

    public String testToken() {
        TokenVO dto = ExtendParameterHelper.getDTO();
        return JSONObject.toJSONString(dto);
    }
}
