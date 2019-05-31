package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统角色资源中间表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@ApiModel(value="RoleResource对象", description="系统角色资源中间表")
@TableName("t_system_role_resource")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "资源ID")
    private Long resourceId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;


}
