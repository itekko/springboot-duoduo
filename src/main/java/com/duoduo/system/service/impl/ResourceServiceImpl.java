package com.duoduo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duoduo.system.entity.Resource;
import com.duoduo.system.mapper.ResourceMapper;
import com.duoduo.system.service.IResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {


    /**
     * 获取菜单树
     * @return
     */
    @Override
    public List<Resource> tree() {
        List<Resource> list = baseMapper.selectList(null);
        List<Resource> tree = null;
        // 获取根节点，默认只有一个根节点
        if (!CollectionUtils.isEmpty(list)){
            Map<Long, List<Resource>> groups = list.stream().collect(Collectors.groupingBy(Resource::getPid));
            tree = groups.get(0L);
            groups.remove(0L);
            if(!CollectionUtils.isEmpty(tree)){
                tree.forEach(item -> {
                    getSonNodes(item,groups);

                });
            }
        }
        return tree;
    }

    private void getSonNodes(Resource resource, Map<Long, List<Resource>> groups) {

        if (!CollectionUtils.isEmpty(groups) && null != resource.getPid()){
            List<Resource> resources = groups.get(resource.getId());
            resource.setResources(resources);
            groups.remove(resource.getPid());
            if (!CollectionUtils.isEmpty(resources)){
                resources.forEach(item -> getSonNodes(item,groups));
            }
        }
    }
}
