package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_role")
@ApiModel(value="Role对象", description="系统角色表")
public class Role extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String rolename;


    @Override
    public String getAuthority() {
        return rolename;
    }
}
