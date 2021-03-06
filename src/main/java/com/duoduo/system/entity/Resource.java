package com.duoduo.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * <p>
 * 系统资源表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_resource")
@ApiModel(value="Resource对象", description="系统资源表")
public class Resource extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父主键，当值为0顶级父ID")
    private Long pid;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "权限标识")
    private String permission;

    @ApiModelProperty(value = "菜单地址")
    private String url;

    @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
    private Integer type;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 子节点
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点")
    private List<Resource> resources;

    @Override
    public String getAuthority() {
        return permission;
    }
}
