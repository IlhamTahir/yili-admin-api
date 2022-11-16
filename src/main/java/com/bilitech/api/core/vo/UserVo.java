package com.bilitech.api.core.vo;

import com.bilitech.api.core.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends BaseVo {

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;
    
    private List<RoleVo> roles;
}
