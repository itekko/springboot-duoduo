/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : duoduo

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-07-11 14:54:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_system_area
-- ----------------------------
DROP TABLE IF EXISTS `t_system_area`;
CREATE TABLE `t_system_area` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '父主键，当值为0，代表顶级地区',
  `name` varchar(32) DEFAULT NULL COMMENT '地区名称',
  `code` varchar(32) DEFAULT NULL COMMENT '地区编码',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型,0:全国，1：省，2：城市，3：县，4：镇，5：村',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统地区表';

-- ----------------------------
-- Records of t_system_area
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dictionary`;
CREATE TABLE `t_system_dictionary` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '标签名',
  `value` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '数据值',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统字典表';

-- ----------------------------
-- Records of t_system_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_log`;
CREATE TABLE `t_system_log` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(64) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统日志表';

-- ----------------------------
-- Records of t_system_log
-- ----------------------------
INSERT INTO `t_system_log` VALUES ('1126055922674360322', null, null, '用户新增', null, 'POST /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:27:07', '2019-05-08 17:27:07');
INSERT INTO `t_system_log` VALUES ('1126056783618170881', null, null, '用户新增', null, 'POST /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:30:32', '2019-05-08 17:30:32');
INSERT INTO `t_system_log` VALUES ('1126057503041970177', null, null, '用户修改', null, 'PUT /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:33:24', '2019-05-08 17:33:24');
INSERT INTO `t_system_log` VALUES ('1126057760458989569', null, null, '用户查询', null, 'GET /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:34:25', '2019-05-08 17:34:25');
INSERT INTO `t_system_log` VALUES ('1126057883486314498', null, null, '用户查询', null, 'GET /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:34:55', '2019-05-08 17:34:55');
INSERT INTO `t_system_log` VALUES ('1126057983088451586', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:35:18', '2019-05-08 17:35:18');
INSERT INTO `t_system_log` VALUES ('1126058026470137858', null, null, '用户删除', null, 'DELETE /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:35:29', '2019-05-08 17:35:29');
INSERT INTO `t_system_log` VALUES ('1126058050151178241', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-08 17:35:34', '2019-05-08 17:35:34');
INSERT INTO `t_system_log` VALUES ('1126293303851687938', null, null, '用户查询', null, 'GET /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:10:23', '2019-05-09 09:10:23');
INSERT INTO `t_system_log` VALUES ('1126293340170166274', null, null, '用户查询', null, 'GET /system/user/1126055922296872961', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:10:32', '2019-05-09 09:10:32');
INSERT INTO `t_system_log` VALUES ('1126293371023466497', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:10:39', '2019-05-09 09:10:39');
INSERT INTO `t_system_log` VALUES ('1126296655499014146', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:23:42', '2019-05-09 09:23:42');
INSERT INTO `t_system_log` VALUES ('1126297520351936513', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:27:09', '2019-05-09 09:27:09');
INSERT INTO `t_system_log` VALUES ('1126301128866820097', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 09:41:29', '2019-05-09 09:41:29');
INSERT INTO `t_system_log` VALUES ('1126307690725384194', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 10:07:33', '2019-05-09 10:07:33');
INSERT INTO `t_system_log` VALUES ('1126457056295550977', null, null, '用户列表查询', null, 'GET /system/user', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-05-09 20:01:05', '2019-05-09 20:01:05');
INSERT INTO `t_system_log` VALUES ('1135387786354536450', null, null, '系统资源树', null, 'GET /system/resource/tree', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-06-03 11:28:37', '2019-06-03 11:28:37');
INSERT INTO `t_system_log` VALUES ('1135387809855221761', null, null, '系统资源树', null, 'GET /system/resource/tree', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-06-03 11:28:43', '2019-06-03 11:28:43');
INSERT INTO `t_system_log` VALUES ('1135389518216212481', null, null, '系统资源树', null, 'GET /system/resource/tree', '{}', '127.0.0.1', null, null, '1', '0', null, null, '2019-06-03 11:35:30', '2019-06-03 11:35:30');

-- ----------------------------
-- Table structure for t_system_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_system_organization`;
CREATE TABLE `t_system_organization` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '父主键，当值为0，代表顶级组织',
  `name` varchar(32) DEFAULT NULL COMMENT '组织名称',
  `code` varchar(32) DEFAULT NULL COMMENT '组织编码',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统组织表';

-- ----------------------------
-- Records of t_system_organization
-- ----------------------------
INSERT INTO `t_system_organization` VALUES ('1135362601748451330', '0', '多多科技', 'G1135362601702789120', '1', '0', '多多科技', '1', '1', '0', null, null, '2019-06-03 09:48:32', '2019-06-03 09:48:32');
INSERT INTO `t_system_organization` VALUES ('1135362602046246914', '1135362601748451330', '技术开发部', 'D1135362602046722048', '1', '1', '技术开发部', '1', '1', '0', null, null, '2019-06-03 09:48:33', '2019-06-03 09:48:33');

-- ----------------------------
-- Table structure for t_system_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_system_resource`;
CREATE TABLE `t_system_resource` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '父主键，当值为0顶级父ID',
  `name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '权限标识',
  `url` varchar(32) DEFAULT NULL COMMENT '菜单地址',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统资源表';

-- ----------------------------
-- Records of t_system_resource
-- ----------------------------
INSERT INTO `t_system_resource` VALUES ('1135358572670742530', '0', '系统管理', 'system', null, '0', null, '1', '系统管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573257945089', '1135358572670742530', '用户管理', 'system:user', null, '0', null, '1', '用户管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573283110913', '1135358572670742530', '角色管理', 'system:role', null, '0', null, '1', '角色管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573299888129', '1135358572670742530', '菜单管理', 'system:resource', null, '0', null, '1', '菜单管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573316665346', '1135358572670742530', '组织管理', 'system:organization', null, '0', null, '1', '组织管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573333442561', '1135358572670742530', '日志管理', 'system:log', null, '0', null, '1', '日志管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573346025474', '1135358572670742530', '字典管理', 'system:dictionary', null, '0', null, '1', '字典管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');
INSERT INTO `t_system_resource` VALUES ('1135358573366996993', '1135358572670742530', 'API管理', 'system:API', null, '0', null, '1', 'API管理', null, '1', '0', null, null, '2019-06-03 09:32:32', '2019-06-03 09:32:32');

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `rolename` varchar(32) DEFAULT NULL COMMENT '用户名',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态,参考字典（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1135362600171393026', '超级管理员', '超级管理员', null, '1', '0', null, null, '2019-06-03 09:48:32', '2019-06-03 09:48:32');
INSERT INTO `t_system_role` VALUES ('1135362600188170241', '平台管理员', '平台管理员', null, '1', '0', null, null, '2019-06-03 09:48:32', '2019-06-03 09:48:32');

-- ----------------------------
-- Table structure for t_system_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role_resource`;
CREATE TABLE `t_system_role_resource` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色资源中间表';

-- ----------------------------
-- Records of t_system_role_resource
-- ----------------------------
INSERT INTO `t_system_role_resource` VALUES ('1135362601219969026', '1135358572670742530', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601228357633', '1135358573257945089', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601236746241', '1135358573283110913', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601253523457', '1135358573299888129', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601261912066', '1135358573316665346', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601270300674', '1135358573333442561', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601278689282', '1135358573346025474', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601287077889', '1135358573366996993', '1135362600171393026');
INSERT INTO `t_system_role_resource` VALUES ('1135362601295466497', '1135358572670742530', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601303855106', '1135358573257945089', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601312243713', '1135358573283110913', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601320632322', '1135358573299888129', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601329020930', '1135358573316665346', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601345798146', '1135358573333442561', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601345798147', '1135358573346025474', '1135362600188170241');
INSERT INTO `t_system_role_resource` VALUES ('1135362601354186753', '1135358573366996993', '1135362600188170241');

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `status` bigint(20) DEFAULT NULL COMMENT '状态:字典类型，参考（t_system_dictionary）',
  `version` int(11) DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除，0：正常，1：已删除',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1135362599726796802', 'admin', '$2a$10$ep1nP9as70A1BoN9P4u1F.5FGU0HoVkOtTra12HQnFMiVa9fGXiiK', null, '1351956953', 'ekkoit@outlook.com', '屌丝', '0', '1', '0', null, null, '2019-06-03 09:48:32', '2019-06-03 09:48:32');

-- ----------------------------
-- Table structure for t_system_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_organization`;
CREATE TABLE `t_system_user_organization` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `organization_id` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户组织中间表';

-- ----------------------------
-- Records of t_system_user_organization
-- ----------------------------
INSERT INTO `t_system_user_organization` VALUES ('1135362602255962114', '1135362602046246914', '1135362599726796802');

-- ----------------------------
-- Table structure for t_system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_role`;
CREATE TABLE `t_system_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户角色中间表';

-- ----------------------------
-- Records of t_system_user_role
-- ----------------------------
INSERT INTO `t_system_user_role` VALUES ('1135362600569851905', '1135362599726796802', '1135362600171393026');
