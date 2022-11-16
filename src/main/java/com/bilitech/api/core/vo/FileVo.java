package com.bilitech.api.core.vo;

import com.bilitech.api.core.enums.FileStatus;
import com.bilitech.api.core.enums.FileType;
import com.bilitech.api.core.enums.Storage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}
