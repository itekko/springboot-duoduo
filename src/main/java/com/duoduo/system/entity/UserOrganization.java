package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户组织中间表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@TableName("t_system_user_organization")
@ApiModel(value="UserOrganization对象", description="系统用户组织中间表")
public class UserOrganization {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "组织ID")
    private Long organizationId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;


}
