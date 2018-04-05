DROP TABLE IF EXISTS sys_function;

DROP TABLE IF EXISTS sys_role;

DROP TABLE IF EXISTS sys_role_function;

DROP TABLE IF EXISTS sys_role_user;

DROP TABLE IF EXISTS sys_user;

/*==============================================================*/
/* Table: sys_function                                          */
/*==============================================================*/
CREATE TABLE sys_function
(
   id                   VARCHAR(64) NOT NULL COMMENT '主键',
   NAME                 VARCHAR(32) NOT NULL COMMENT '权限名称',
   parent_id            VARCHAR(64) COMMENT '父级id',
   order_num            INT COMMENT '排序',
   url                  VARCHAR(256) COMMENT '链接',
   description          VARCHAR(256) COMMENT '描述',
   create_time          DATETIME COMMENT '创建时间',
   update_time          DATETIME COMMENT '修改时间',
   PRIMARY KEY (id)
);

ALTER TABLE sys_function COMMENT '权限表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
CREATE TABLE sys_role
(
   id                   VARCHAR(64) NOT NULL COMMENT '主键',
   NAME                 VARCHAR(64) NOT NULL COMMENT '角色名称',
   description          VARCHAR(256) COMMENT '角色描述',
   create_time          DATETIME COMMENT '创建时间',
   update_time          DATETIME COMMENT '修改时间',
   PRIMARY KEY (id)
);

ALTER TABLE sys_role COMMENT '角色表';

/*==============================================================*/
/* Table: sys_role_function                                     */
/*==============================================================*/
CREATE TABLE sys_role_function
(
   id                   VARCHAR(64) NOT NULL COMMENT '主键',
   role_id              VARCHAR(64) COMMENT '角色id',
   function_id          VARCHAR(64) COMMENT '权限id',
   PRIMARY KEY (id)
);

ALTER TABLE sys_role_function COMMENT '角色权限表';

/*==============================================================*/
/* Table: sys_role_user                                         */
/*==============================================================*/
CREATE TABLE sys_role_user
(
   id                   VARCHAR(64) NOT NULL COMMENT '主键',
   role_id              VARCHAR(64) COMMENT '主键',
   user_id              VARCHAR(64) COMMENT '主键',
   PRIMARY KEY (id)
);

ALTER TABLE sys_role_user COMMENT '用户角色表 sys_role_user';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
CREATE TABLE sys_user
(
   id                   VARCHAR(64) NOT NULL COMMENT '主键',
   account              VARCHAR(32) NOT NULL COMMENT '姓名',
   PASSWORD             VARCHAR(32) COMMENT '密码',
   username             VARCHAR(64) COMMENT '用户名称',
   is_delete            CHAR(1) COMMENT '用户状态 - 0：正常，1：删除',
   create_time          DATETIME COMMENT '创建时间',
   update_time          DATETIME COMMENT '修改时间',
   PRIMARY KEY (id)
);

ALTER TABLE sys_user COMMENT '用户表';

ALTER TABLE sys_role_function ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (role_id)
      REFERENCES sys_role (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE sys_role_function ADD CONSTRAINT FK_Reference_5 FOREIGN KEY (function_id)
      REFERENCES sys_function (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE sys_role_user ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (role_id)
      REFERENCES sys_role (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE sys_role_user ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (user_id)
      REFERENCES sys_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;