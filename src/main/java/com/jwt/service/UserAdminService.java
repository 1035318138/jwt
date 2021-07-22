package com.jwt.service;

import com.jwt.dto.LoginDTO;
import com.jwt.dto.TokenVO;
import com.jwt.entity.User;
import com.jwt.util.JWTUtil;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public String login(LoginDTO loginDTO) {
        User user = getLoginUserInfo(loginDTO.getUserName());
        List<Integer> roles = userRoleService.getUserRoleList(user.getId());
        TokenVO tokenVO = TokenVO.builder().id(user.getId()).name(user.getName()).password(user.getPassword()).roles(roles).build();
        return jwtUtil.createToken(tokenVO);
    }

    private User getLoginUserInfo(String userName) {
        SQL sql = new SQL().SELECT("*").FROM(tableName).WHERE(User.NAME);
        Object[] param = new Object[]{userName};
        return jdbcTemplate.queryForObject(sql.toString(), param, new BeanPropertyRowMapper<User>(User.class));
    }

    public String testToken(LoginDTO loginDTO) {
        return loginDTO.getUserName();
    }
}
