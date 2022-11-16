package com.bilitech.api.core.repository;

import com.bilitech.api.core.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
