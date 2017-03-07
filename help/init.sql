-- 初始化角色
INSERT INTO `t_sys_role` (`id`, `name`, `code`, `sort`, `status`) VALUES ('1', '管理员', 'ROLE_ADMIN', '1', '1');
INSERT INTO `t_sys_role` (`id`, `name`, `code`, `sort`, `status`) VALUES ('2', '用户', 'ROLE_USER', '2', '1');

--  初始化用户
INSERT INTO `t_sys_user` (`id`, `login_name`, `name`, `pwd`, `status`, `sort`) VALUES ('1', 'admin1', '管理员1', '123', '1', '1');
INSERT INTO `t_sys_user` (`id`, `login_name`, `name`, `pwd`, `status`, `sort`) VALUES ('2', 'user1', '用户1', '123', '1', '1');
-- 初始用户角色表
INSERT INTO `t_sys_user_role` (`id`, `user_id`, `role_id`) VALUES ('1', '1', '1');
INSERT INTO `t_sys_user_role` (`id`, `user_id`, `role_id`) VALUES ('2', '2', '2');

-- 添加测试资源
INSERT INTO `t_sys_resource` (`id`, `code`, `resource_type`, `status`, `sort`) VALUES ('1', '/demo/role/test/user', '0', '1', '1');
INSERT INTO `t_sys_resource` (`id`, `code`, `resource_type`, `status`, `sort`) VALUES ('2', '/demo/role/test/admin', '0', '1', '2');

-- 添加资源角色
INSERT INTO `t_sys_resource_role` (`id`, `resource_id`, `role_id`) VALUES ('1', '1', '2');
INSERT INTO `t_sys_resource_role` (`id`, `resource_id`, `role_id`) VALUES ('2', '2', '1');
