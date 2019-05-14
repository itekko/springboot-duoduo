package com.duoduo.system.service.impl;

import com.duoduo.system.entity.Organization;
import com.duoduo.system.mapper.OrganizationMapper;
import com.duoduo.system.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统组织表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

}
