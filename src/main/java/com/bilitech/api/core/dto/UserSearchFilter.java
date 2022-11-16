package com.bilitech.api.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class UserSearchFilter extends BaseSearchFilter {
    private String nickname;
}
