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
@ApiModel("用户角色")
@Table(name = "`t_user_role`")
public class UserRole {

    @Column(name = "`id`")
    @ApiModelProperty("主键Id")
    private Integer id;

    @Column(name = "`userId`")
    @ApiModelProperty("用户Id")
    private String userId;

    @Column(name = "`roleId`")
    @ApiModelProperty("角色Id")
    private String roleId;

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
    public static final String USER_ID = "userId=?";
    public static final String ROLE_ID = "roleId=?";
    public static final String IS_VALID = "isValid=?";

    public static final String DB_ID = "id";
    public static final String DB_USER_ID = "userId";
    public static final String DB_ROLE_ID = "roleId";
    public static final String DB_IS_VALID = "isValid";
}
