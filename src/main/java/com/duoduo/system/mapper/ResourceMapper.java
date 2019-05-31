package com.duoduo.system.mapper;

import com.duoduo.system.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duoduo.system.entity.User;

import java.util.List;

/**
 * <p>
 * 系统资源表 Mapper 接口
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> selectListByUser(User user);
}
