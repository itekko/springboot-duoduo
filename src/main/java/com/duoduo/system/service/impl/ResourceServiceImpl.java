package com.duoduo.system.service.impl;

import com.duoduo.system.entity.Resource;
import com.duoduo.system.mapper.ResourceMapper;
import com.duoduo.system.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
