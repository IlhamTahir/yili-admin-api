package com.bilitech.api.core.service;

import com.bilitech.api.core.dto.FileDto;
import com.bilitech.api.core.dto.FileUploadDto;
import com.bilitech.api.core.dto.FileUploadRequest;
import com.bilitech.api.core.entity.File;
import com.bilitech.api.core.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}
