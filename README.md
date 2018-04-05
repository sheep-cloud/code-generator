# 针对项目中的不同情况，生成不同的代码，相关项目未完善，无法运行，仅供生成代码。
---

### 参考：
[MyBatis Generator介绍](http://mbg.cndocs.ml/)

[MyBatis Generator 详解](https://blog.csdn.net/isea533/article/details/42102297)

### SQL：
```
drop table if exists sys_function;

drop table if exists sys_role;

drop table if exists sys_role_function;

drop table if exists sys_role_user;

drop table if exists sys_user;

/*==============================================================*/
/* Table: sys_function                                          */
/*==============================================================*/
create table sys_function
(
   id                   varchar(64) not null comment '主键',
   name                 varchar(32) not null comment '权限名称',
   parent_id            varchar(64) comment '父级id',
   order_num            int comment '排序',
   url                  varchar(256) comment '链接',
   description          varchar(256) comment '描述',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table sys_function comment '权限表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   varchar(64) not null comment '主键',
   name                 varchar(64) not null comment '角色名称',
   description          varchar(256) comment '角色描述',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table sys_role comment '角色表';

/*==============================================================*/
/* Table: sys_role_function                                     */
/*==============================================================*/
create table sys_role_function
(
   id                   varchar(64) not null comment '主键',
   role_id              varchar(64) comment '角色id',
   function_id          varchar(64) comment '权限id',
   primary key (id)
);

alter table sys_role_function comment '角色权限表';

/*==============================================================*/
/* Table: sys_role_user                                         */
/*==============================================================*/
create table sys_role_user
(
   id                   varchar(64) not null comment '主键',
   role_id              varchar(64) comment '主键',
   user_id              varchar(64) comment '主键',
   primary key (id)
);

alter table sys_role_user comment '用户角色表 sys_role_user';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   varchar(64) not null comment '主键',
   account              varchar(32) not null comment '姓名',
   password             varchar(32) comment '密码',
   username             varchar(64) comment '用户名称',
   is_delete            char(1) comment '用户状态 - 0：正常，1：删除',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   primary key (id)
);

alter table sys_user comment '用户表';

alter table sys_role_function add constraint FK_Reference_4 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

alter table sys_role_function add constraint FK_Reference_5 foreign key (function_id)
      references sys_function (id) on delete restrict on update restrict;

alter table sys_role_user add constraint FK_Reference_1 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

alter table sys_role_user add constraint FK_Reference_2 foreign key (user_id)
      references sys_user (id) on delete restrict on update restrict;

```