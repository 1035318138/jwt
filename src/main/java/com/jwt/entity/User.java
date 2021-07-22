package com.jwt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Can.Ru
 */
@Data
@ApiModel("用户")
@Table(name = "`t_user`")
public class User {

    @Column(name = "`id`")
    @ApiModelProperty("主键Id")
    private Integer id;

    @Column(name = "`name`")
    @ApiModelProperty("账号")
    private String name;

    @Column(name = "`password`")
    @ApiModelProperty("密码")
    private String password;

    public static final String ID = "id=?";
    public static final String NAME = "name=?";
    public static final String PASSWORD = "password=?";

    public static final String DB_ID = "id";
    public static final String DB_NAME = "name";
    public static final String DB_PASSWORD = "password";
}
