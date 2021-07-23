package com.jwt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Can.Ru
 */
@Data
@SuperBuilder
public class TokenVO {
    @ApiModelProperty("主键Id")
    private Integer id;

    @ApiModelProperty("账号")
    private String name;

    @ApiModelProperty("角色组")
    private List<Integer> roles;
}
