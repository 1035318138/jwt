package com.jwt.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Can.Ru
 */
@Builder
@Data
public class LoginDTO {

    private String userName;

    private String password;
}
