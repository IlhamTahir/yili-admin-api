package com.bilitech.api.core.dto;

import com.bilitech.api.core.enums.FileStatus;
import com.bilitech.api.core.enums.FileType;
import com.bilitech.api.core.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private String key;

    private String uri;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
