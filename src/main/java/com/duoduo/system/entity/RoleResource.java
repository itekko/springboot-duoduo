package com.duoduo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统角色资源中间表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@Accessors(chain = true)
@TableName("t_system_role_resource")
public class RoleResource {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 资源ID
     */
    private Long resourceId;

    /**
     * 角色ID
     */
    private Long roleId;


}
