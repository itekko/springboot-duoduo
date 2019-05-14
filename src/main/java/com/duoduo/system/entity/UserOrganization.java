package com.duoduo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户组织中间表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@Accessors(chain = true)
@TableName("t_system_user_organization")
public class UserOrganization {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织ID
     */
    private Long organizationId;

    /**
     * 用户ID
     */
    private Long userId;


}
