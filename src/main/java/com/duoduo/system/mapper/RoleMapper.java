package com.duoduo.system.mapper;

import com.duoduo.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectListByUserId(Long userId);
}
