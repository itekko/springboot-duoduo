package com.duoduo.system.service.impl;

import com.duoduo.system.entity.Role;
import com.duoduo.system.mapper.RoleMapper;
import com.duoduo.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
