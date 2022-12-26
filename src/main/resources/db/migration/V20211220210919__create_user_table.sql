CREATE TABLE `user` (
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '用户ID',
    `username` VARCHAR(64) NOT NULL COMMENT '用户名',
    `nickname` VARCHAR(64) NULL COMMENT '用户昵称',
    `password` VARCHAR(64) NOT NULL COMMENT '加密后的密码',
    `gender` VARCHAR(255) NULL COMMENT '性别',
    `locked` TINYINT(1) DEFAULT 0 NOT NULL COMMENT '是否锁定，1-是，0-否',
    `enabled` TINYINT(1) DEFAULT 1 NOT NULL COMMENT '是否可用，1-是，0-否',
    `last_login_ip` VARCHAR(64) NULL COMMENT '最后登录IP',
    `last_login_time` DATETIME(6) NULL COMMENT '最后登录IP',
    `created_time` DATETIME(6) NOT NULL COMMENT '创建时间',
    `updated_time` DATETIME(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT `uk_user_username`
        UNIQUE (`username`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = `utf8mb4`
    COLLATE = `utf8mb4_bin` COMMENT '用户表';

CREATE TABLE `role` (
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '角色ID',
    `name` VARCHAR(128) NULL COMMENT '角色名称',
    `label` VARCHAR(128) NULL COMMENT '角色标识',
    `created_time` DATETIME(6) NOT NULL COMMENT '创建时间',
    `updated_time` DATETIME(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT `uk_role_name`
        UNIQUE (`name`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = `utf8mb4`
    COLLATE = `utf8mb4_bin` COMMENT '角色表';

CREATE TABLE `user_role` (
    `user_id` VARCHAR(32) NOT NULL COMMENT '用户ID',
    `role_id` VARCHAR(32) NOT NULL COMMENT '角色ID'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = `utf8mb4`
    COLLATE = `utf8mb4_bin` COMMENT '用户角色表';

CREATE TABLE `permission` (
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '权限ID',
    `name` VARCHAR(128) NOT NULL COMMENT '权限名称',
    `created_time` DATETIME(6) NOT NULL COMMENT '创建时间',
    `updated_time` DATETIME(6) NOT NULL COMMENT '创建时间',
    CONSTRAINT `uk_permission_name`
        UNIQUE (`name`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = `utf8mb4`
    COLLATE = `utf8mb4_bin` COMMENT '权限表';


CREATE TABLE `role_permission` (
    `role_id` VARCHAR(32) NOT NULL COMMENT '角色ID',
    `permission_id` VARCHAR(32) NOT NULL COMMENT '权限ID'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = `utf8mb4`
    COLLATE = `utf8mb4_bin` COMMENT '角色权限表';
