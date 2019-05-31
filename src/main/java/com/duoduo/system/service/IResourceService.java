package com.duoduo.system.service;

import com.duoduo.system.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统资源表 服务类
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> tree();
}
