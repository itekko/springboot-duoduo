package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统资源表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_resource")
public class Resource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父主键，当值为0顶级父ID
     */
    private Long pid;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Boolean type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer order;


}
