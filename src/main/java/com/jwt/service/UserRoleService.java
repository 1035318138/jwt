package com.jwt.service;

import com.jwt.entity.User;
import com.jwt.entity.UserRole;
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
public class UserRoleService {

    public static String tableName = "t_user_role";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Integer> getUserRoleList(Integer userId) {
        SQL sql = new SQL().SELECT(UserRole.DB_ROLE_ID).FROM(tableName).WHERE(UserRole.USER_ID).WHERE(UserRole.IS_VALID);
        Object[] param = new Object[]{userId,1};
        return jdbcTemplate.queryForList(sql.toString(), param, Integer.class);
    }
}
