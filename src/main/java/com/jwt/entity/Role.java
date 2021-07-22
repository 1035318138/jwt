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
@ApiModel("角色")
@Table(name = "`t_role`")
public class Role {

    @Column(name = "`id`")
    @ApiModelProperty("主键Id")
    private Integer id;

    @Column(name = "`roleKey`")
    @ApiModelProperty("roleKey")
    private String roleKey;

    @Column(name = "`roleName`")
    @ApiModelProperty("角色名称")
    private String roleName;

    @Column(name = "`createTime`")
    @ApiModelProperty("创建时间")
    private String createTime;


    @Column(name = "`updateTime`")
    @ApiModelProperty("创建时间")
    private String updateTime;

    @Column(name = "`createBy`")
    @ApiModelProperty("创建人")
    private String createBy;


    @Column(name = "`updateBy`")
    @ApiModelProperty("修改人")
    private String updateBy;

    @Column(name = "`isValid`")
    @ApiModelProperty("是否删除 0:已删除 1:未删除")
    private String isValid;


    public static final String ID = "id=?";
    public static final String NAME = "name=?";
    public static final String PASSWORD = "password=?";

    public static final String DB_ID = "id";
    public static final String DB_NAME = "name";
    public static final String DB_PASSWORD = "password";
}
