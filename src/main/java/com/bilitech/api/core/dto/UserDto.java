package com.bilitech.api.core.dto;

import com.bilitech.api.core.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto extends BaseDto{

    private String username;

    private String nickname;

    private List<RoleDto> roles;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;
    
    private String lastLoginIp;

    private Date lastLoginTime;
}
